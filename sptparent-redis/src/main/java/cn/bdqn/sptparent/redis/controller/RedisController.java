package cn.bdqn.sptparent.redis.controller;

import cn.bdqn.sptparent.redis.po.Category;
import cn.bdqn.sptparent.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("")
    public Object get(){
        System.out.println("储存新的值");
        if(!redisTemplate.hasKey("get")){
            String value="abc";
            redisTemplate.opsForValue().set("get",value);
        }
        return redisTemplate.opsForValue().get("get");
    }

    @RequestMapping("/view/{id}")
    public List<Category> getAll(@PathVariable("id") String id){
// 判断Redis中是否已有该key  category/getAll
        List<Category> list = null;
        if(redisUtil.hasKey("category/getAll")){// 已存在
            System.out.println("已存在");
            int len = Integer.valueOf((String)redisUtil.get("category/getAll/count"));
            ArrayList<Category> arrayList = new ArrayList<Category>(redisUtil.getZset("category/getAll",0,len));
            return null;
        }else{// 不存在 或 已过期
            System.out.println("不存在");
            // 查询数据库
            list = new ArrayList<Category>();// 即使数据库没有值，也存放到redis中
            for (int i = 0; i < 10; i++) {
                list.add(new Category(i+1000,"正在"+i,"asd/asd"));
            }
            // 存放数据库
            redisUtil.addZset("category/getAll",list,60);
            redisUtil.set("category/getAll/count",list.size()+"",60);
        }
        return list;
    }
}
