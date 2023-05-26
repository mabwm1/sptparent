package cn.bdqn.sptparent.web.controller;


import cn.bdqn.sptparent.domain.po.Productimage;
import cn.bdqn.sptparent.service.ProductimageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/productimage")
public class ProductimageController {
    @Resource
    private ProductimageService productimageService;

    @GetMapping("/top")
    public List<Productimage> top(
            @RequestParam(value = "size",required = false,defaultValue = "5") long size,HttpServletRequest request){
        QueryWrapper<Productimage> queryWrapper = new QueryWrapper<Productimage>();
        queryWrapper.lambda().orderByAsc(Productimage::getProductimageId);
        List<Productimage> list = productimageService.page(new Page<Productimage>(1,size),queryWrapper).getRecords();

        list.forEach(productimage -> productimage.setProductimageSrc(
                request.getProtocol().replace("/1.1","") + "://" + request.getServerName()+":"+request.getServerPort()
                        +"/static/images/item/productSinglePicture/"
                        +productimage.getProductimageSrc()));
        return list;
    }
}