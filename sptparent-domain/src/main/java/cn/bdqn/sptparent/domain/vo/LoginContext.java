package cn.bdqn.sptparent.domain.vo;

import cn.bdqn.sptparent.domain.po.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Data
public class LoginContext {
    private Integer userId;
    private String userNickName;
    private Boolean userGender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date userBirthday;
    private String userProfilePictureSrc;

    private Integer age;// 年龄
    private String loginIP;// 登录IP
    private String loginType;// 登录方式
    private String[] groups;// 权限组
    private String token;
    private String logindate;

    public LoginContext(){}

    public LoginContext(User user, HttpServletRequest request){
        this.setUserId(user.getUserId());
        this.setUserNickName(user.getUserNickName());
        //this.setAge();
        this.setLoginIP(request.getRemoteAddr());
        String type = request.getHeader("User-Agent");
        if(type.contains("Windows")){
            this.setLoginType("pc");
        }else if(type.contains("iPhone")){
            this.setLoginType("mobile");
        }else if(type.contains("iPad")){
            this.setLoginType("ipad");
        }
    }
}
