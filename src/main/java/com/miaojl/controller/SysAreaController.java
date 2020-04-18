package com.miaojl.controller;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Result;
import com.miaojl.entity.SysArea;
import com.miaojl.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/18
 * @description 区域控制器
 */
@RestController
@RequestMapping("manager/area")
public class SysAreaController {

    @Autowired
    SysAreaService sysAreaService;

    @RequestMapping("index")
    public ModelAndView area(){
        return new ModelAndView("area/area");
    }

    @RequestMapping("doSelect/{pageNum}/{pageSize}")
    public Result doSelect(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        PageInfo<SysArea> sysAreaList = sysAreaService.selectPage(pageNum,pageSize);
        return new Result(true,"成功",sysAreaList);
    }

}
