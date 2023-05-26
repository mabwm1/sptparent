package cn.bdqn.sptparent.mybatisplus.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("user")
@Data
public class User {
    @TableId(value = "userId",type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String userNickName;
    private String userPassword;
    private String userRealname;
    private Byte userGender;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirthday;
    private String userAddress;
    private String userHomePlace;
    private String userProfilePictureSrc;
}
