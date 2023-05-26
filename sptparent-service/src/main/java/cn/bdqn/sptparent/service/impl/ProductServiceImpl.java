package cn.bdqn.sptparent.service.impl;

import cn.bdqn.sptparent.dao.ProductMapper;
import cn.bdqn.sptparent.domain.po.Product;
import cn.bdqn.sptparent.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhl
 * @since 2023-05-17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
