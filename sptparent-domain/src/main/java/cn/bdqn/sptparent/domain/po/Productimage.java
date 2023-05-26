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
@ApiModel(value="Productimage对象", description="")
public class Productimage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "productimageId", type = IdType.AUTO)
    private Integer productimageId;

    private Integer productimageType;

    private String productimageSrc;

    private Integer productimageProductId;


}
