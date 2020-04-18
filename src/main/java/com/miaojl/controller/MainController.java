package com.miaojl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mjl
 * @date 2020/4/11
 * @description 公共页控制层
 */
@Controller
@RequestMapping("common")
public class MainController {

    @RequestMapping("navbar")
    public String getNavbar(){
        return "common/navbar";
    }
    @RequestMapping("sidebar")
    public String getSidebar(){
        return "common/sidebar";
    }

}
