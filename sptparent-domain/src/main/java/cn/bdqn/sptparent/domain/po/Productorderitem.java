package cn.bdqn.sptparent.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
@ApiModel(value="Productorderitem对象", description="")
public class Productorderitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "productorderitemId", type = IdType.AUTO)
    private Integer productorderitemId;

    private Integer productorderitemNumber;

    private BigDecimal productorderitemPrice;

    private Integer productorderitemProductId;

    private Integer productorderitemOrderId;

    private Integer productorderitemUserId;

    private String productorderitemUserMessage;


}
