package cn.bdqn.sptparent.service.impl;

import cn.bdqn.sptparent.dao.CategoryMapper;
import cn.bdqn.sptparent.domain.po.Category;
import cn.bdqn.sptparent.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
