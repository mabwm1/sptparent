package cn.bdqn.sptparent.web.controller;


import cn.bdqn.sptparent.domain.po.Product;
import cn.bdqn.sptparent.redis.utils.RedisUtil;
import cn.bdqn.sptparent.service.ProductService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhl
 * @since 2023-05-17
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("view/{id}")
    public String getById(@PathVariable("id") Integer productId, Model model){
        String key = "product:view:"+productId;
        if(redisUtil.hasKey(key)){
            model.addAttribute("product", JSON.parse(redisUtil.get(key).toString()));
        }else {
            Product product = productService.getById(productId);
            redisUtil.set(key,product,60);
            model.addAttribute("product",product);
        }
        return "product/view";
    }

}
