package com.miaojl.controller;

/**
 * @author mjl
 * @date 2020/4/16
 * @description 国家法规规定
 */

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Result;
import com.miaojl.entity.Statute;
import com.miaojl.service.StatuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * RestController 全ajax交互,默认自动添加@ResponseBody,
 * 返回值类型是ModelAndView才会走视图解析器
 */
@RestController
/*
 * 如果部署应用不添加应用名，则访问当前index请求为例:
 * /manager/examine/index     =>  查找到tomcat自带的  manager项目
 *
 * */
@RequestMapping("manager/statute")
public class StatuteController {
    @Autowired
    StatuteService service;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("/statute/index");//  "/WEB-INF/html"+"/examine/index"+".html"
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        return new ModelAndView("/statute/update");//  "/WEB-INF/html"+"/examine/index"+".html"
    }

    @RequestMapping(value = "selectPage/{pageNum}/{pageSize}")
    public Result selectPage(Integer type, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize ){
        PageInfo<Statute> pageInfo = service.selectPage(pageNum, pageSize,type);
        return new Result(true,"查询成功",pageInfo);//Result 统一结果响应
    }

    @RequestMapping(value = "doUpdate",method = RequestMethod.PUT)
    public Result doUpdate(@RequestBody Statute statute){
        //设置更新时间
        Result result = new Result();
        statute.setUpdateDate(new Date());
        int i = service.updateByPrimaryKeySelective(statute);
        if(i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }else{
            result.setMsg("更新失败");
        }
        return result;
    }
}
