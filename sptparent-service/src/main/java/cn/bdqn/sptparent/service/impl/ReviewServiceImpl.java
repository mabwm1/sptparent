package cn.bdqn.sptparent.service.impl;

import cn.bdqn.sptparent.dao.ReviewMapper;
import cn.bdqn.sptparent.domain.po.Review;
import cn.bdqn.sptparent.service.ReviewService;
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
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

}
