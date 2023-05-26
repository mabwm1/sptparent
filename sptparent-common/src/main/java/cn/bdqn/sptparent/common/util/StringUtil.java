package cn.bdqn.sptparent.common.util;

import cn.bdqn.sptparent.domain.po.UserPO;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class StringUtil {
    public static String format(String str,String encoding) throws UnsupportedEncodingException {
        UserPO userPO = new UserPO();
        return new String(str.getBytes(StandardCharsets.UTF_8),encoding);
    }
}
