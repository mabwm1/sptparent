package cn.bdqn.sptparent.mybatisplus.service.impl;

import cn.bdqn.sptparent.mybatisplus.mapper.UserMapper;
import cn.bdqn.sptparent.mybatisplus.po.User;
import cn.bdqn.sptparent.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public List<User> test() {
        return baseMapper.selectList(null);
    }
}
