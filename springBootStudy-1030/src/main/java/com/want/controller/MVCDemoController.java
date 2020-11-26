package com.want.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.want.entity.User;
@Controller
public class MVCDemoController {
    //映射URL地址
    @GetMapping("/mvcdemo")
    public ModelAndView hello() {
        //实例化对象
        User user=new User();
        user.setName("zhonghua");
        user.setAge(28);
        //定义mvc中的视图模板
        ModelAndView modelAndView=new ModelAndView("example/mvcdemo");
        //传递user实体对象给视图
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
