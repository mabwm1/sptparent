package cn.bdqn.sptparent.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhl
 * @since 2023-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Productorder对象", description="")
public class Productorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "productorderId", type = IdType.AUTO)
    private Integer productorderId;

    private String productorderCode;

    private String productorderAddress;

    private String productorderDetailAddress;

    private String productorderPost;

    private String productorderReceiver;

    private String productorderMobile;

    private Date productorderPayDate;

    private Date productorderDeliveryDate;

    private Date productorderConfirmDate;

    private Boolean productorderStatus;

    private Integer productorderUserId;


}
