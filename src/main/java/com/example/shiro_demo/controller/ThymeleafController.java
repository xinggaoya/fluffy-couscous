package com.example.shiro_demo.controller;

import com.example.shiro_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XingGao
 * @Date: 2022/03/28 14:26
 * @Description:
 */
@Controller
public class ThymeleafController {

    @Autowired
    private UserService userService;

    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        return "/user/show";
    }
    @GetMapping("/test")
    public String demo(Model model){
        model.addAttribute("list",userService.getBaseMapper().selectList(null));
        return "/demo";
    }
}
