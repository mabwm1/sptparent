package cn.bdqn.sptparent.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@ApiModel(value="Propertyvalue对象", description="")
public class Propertyvalue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "propertyValueId", type = IdType.AUTO)
    private Integer propertyValueId;

    private String propertyValueValue;

    private Integer propertyValuePropertyId;

    private Integer propertyValueProductId;


}
