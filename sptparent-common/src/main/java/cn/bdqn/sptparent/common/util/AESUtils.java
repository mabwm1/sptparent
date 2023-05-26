package cn.bdqn.sptparent.common.util;

import cn.bdqn.sptparent.domain.vo.LoginContext;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
        private static final Logger LOGGER = LoggerFactory
                .getLogger(AESUtils.class);
        //暂时  后续可以走配置文件配置
        private final static String ASE_KEY = "i0380w330bwda14m";

        public static String encrypt(String source) throws Exception {
            return encrypt(source, ASE_KEY);
        }

        public static String decrypt(String enkey) throws Exception {
            return decrypt(enkey, ASE_KEY);
        }

        public static String encrypt(String sSrc, String sKey) throws Exception {
            if(!checkBlank(sSrc,sKey)){
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

            return Base64Utils.encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        }

        // 解密
        public static String decrypt(String sSrc, String sKey) throws Exception {
            try {
                if(!checkBlank(sSrc,sKey)){
                    return null;
                }
                byte[] raw = sKey.getBytes("utf-8");
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
                StringBuilder sSrcBuilder = new StringBuilder(sSrc);
                while(sSrcBuilder.length() % 4 != 0) {
                    sSrcBuilder.append("=");
                }
                sSrc = sSrcBuilder.toString();
                byte[] encrypted1 = Base64Utils.decode(sSrc);//先用base64解密
                try {
                    byte[] original = cipher.doFinal(encrypted1);
                    String originalString = new String(original, "utf-8");
                    return originalString;
                } catch (Exception e) {
                    LOGGER.error(e.toString());
                    return null;
                }
            } catch (Exception ex) {
                LOGGER.error(ex.toString());
                return null;
            }
        }

        private static boolean checkBlank(String sSrc, String sKey){
            // 判断Key是否正确
            if (sKey == null) {
                LOGGER.error("Key为空null");
                return false;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                LOGGER.error("Key长度不是16位");
                return false;
            }
            return true;
        }

        public static void main(String args[]) throws Exception {


            // 字符串
            System.out.println(AESUtils.encrypt("admin1992"));
            System.out.println(AESUtils.decrypt("FF7QC0jfTFZ3H0v9ahZ80w=="));
            System.out.println("~~~~~~~~~~~~~~~");
            // 对象
            LoginContext loginContext = new LoginContext();
            loginContext.setUserId(10001);
            loginContext.setUserNickName("张三");
            String token = AESUtils.encrypt(JSON.toJSONString(loginContext));
            System.out.println(token);
            LoginContext u2 = JSON.parseObject(AESUtils.decrypt(token),LoginContext.class);
            System.out.println(u2);
        }
    }
