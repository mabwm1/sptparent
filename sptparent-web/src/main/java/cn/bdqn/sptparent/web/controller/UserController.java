package cn.bdqn.sptparent.web.controller;


import cn.bdqn.sptparent.common.util.AESUtils;
import cn.bdqn.sptparent.domain.param.LoginParam;
import cn.bdqn.sptparent.domain.po.User;
import cn.bdqn.sptparent.domain.vo.LoginContext;
import cn.bdqn.sptparent.service.UserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhl
 * @since 2023-05-17
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public LoginContext login(@RequestBody LoginParam loginParam, HttpServletRequest request) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.lambda()
                .eq(User::getUserName,loginParam.getUsername())
                .eq(User::getUserPassword,loginParam.getPassword());
        LoginContext loginContext = new LoginContext(userService.getOne(queryWrapper),request);
        String token = AESUtils.encrypt(JSON.toJSONString(loginContext));
        System.out.println(token);
        loginContext.setToken(token);
        LoginContext u2  = JSON.parseObject(AESUtils.decrypt(token), LoginContext.class);
        System.out.println(u2);
        return loginContext;
    }

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
