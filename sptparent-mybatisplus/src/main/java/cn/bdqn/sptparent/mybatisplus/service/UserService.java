package cn.bdqn.sptparent.mybatisplus.service;

import cn.bdqn.sptparent.mybatisplus.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {
    public List<User> test();
}
