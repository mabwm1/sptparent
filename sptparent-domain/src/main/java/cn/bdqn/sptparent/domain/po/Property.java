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
@ApiModel(value="Property对象", description="")
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "propertyId", type = IdType.AUTO)
    private Integer propertyId;

    private String propertyName;

    private Integer propertyCategoryId;


}
