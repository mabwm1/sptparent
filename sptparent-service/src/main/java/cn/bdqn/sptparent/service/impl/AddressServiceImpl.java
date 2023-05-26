package cn.bdqn.sptparent.service.impl;

import cn.bdqn.sptparent.dao.AddressMapper;
import cn.bdqn.sptparent.domain.po.Address;
import cn.bdqn.sptparent.service.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
