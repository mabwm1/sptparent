package cn.bdqn.sptparent.mybatisplus.controller;

import cn.bdqn.sptparent.mybatisplus.po.User;
import cn.bdqn.sptparent.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("")
    public List<User> getAll(){
        return userService.list();
    }

    @PostMapping("add")
    public Boolean add(@RequestBody User user){
        user.setUserBirthday(new Date());
        return userService.save(user);
    }

    @GetMapping("page")
    public IPage<User> page(
            @RequestParam(value = "pageNum",defaultValue = "1",required = false) Long pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Long pageSize
            ){
        return userService.page(new Page<User>(pageNum,pageSize));
    }

    @GetMapping("like")
    public List<User> like(String name){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("userName",name);
        return userService.list(queryWrapper);
    }

    @GetMapping("like2")
    public IPage<User> like2(
            @RequestParam(value = "pageNum",defaultValue = "1",required = false) Long pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Long pageSize
            ,String name){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.lambda()
                .like(User::getUserName,name)
                .or().like(User::getUserRealname,name)
                .or().like(User::getUserNickName,name)
                .orderByAsc(User::getUserBirthday);
        return userService.page(new Page<User>(pageNum,pageSize),queryWrapper);
    }
}
