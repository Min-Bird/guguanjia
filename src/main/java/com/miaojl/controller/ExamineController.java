package com.miaojl.controller;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Examine;
import com.miaojl.entity.Result;
import com.miaojl.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author mjl
 * @date 2020/4/14
 * @description 考核控制器
 */
@RestController
@RequestMapping("manager/examine")
public class ExamineController {

    @Autowired
    ExamineService examineService;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("examine/index");
    }

    @RequestMapping("selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,@RequestBody Map<String,Object> params){
        PageInfo<Examine> pageInfo = examineService.selectPage(pageNum, pageSize,params);
         return new Result(true,"成功",pageInfo);
    }

    
}
