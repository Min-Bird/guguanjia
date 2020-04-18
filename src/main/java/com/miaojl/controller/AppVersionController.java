package com.miaojl.controller;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.AppVersion;
import com.miaojl.entity.Result;
import com.miaojl.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author mjl
 * @date 2020/4/9
 * @description AppVersion控制器
 */
@RestController
@RequestMapping("manager/app") //manager/app/index
public class AppVersionController {

    @Autowired
    AppVersionService appVersionService;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("app/index");
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        return new ModelAndView("app/update");
    }

    @RequestMapping("selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        PageInfo<AppVersion> pageInfo = appVersionService.selectPage(pageNum, pageSize);
        return new Result(true,"成功",pageInfo);
    }

    @RequestMapping(value = "doUpdate",method = RequestMethod.PUT)
    public Result doUpdate(@RequestBody AppVersion appVersion){
        Result result = new Result();
        appVersion.setUpdateDate(new Date());
        int i = appVersionService.updateByPrimaryKeySelective(appVersion);
        if(i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }else{
            result.setMsg("更新失败");
        }
        return result;
    }

    @RequestMapping(value = "doInsert" , method = RequestMethod.POST)
    public Result doInsert(@RequestBody AppVersion appVersion){
        Result result = new Result();
        appVersion.setDelFlag("0");
        appVersion.setCreateDate(new Date());
        appVersion.setUpdateDate(new Date());
        //TODO 添加创建人
        appVersion.setCreateBy("2");
        int i = appVersionService.insertSelective(appVersion);
        if (i>0){
            result.setSuccess(true);
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping(value = "doDelete/{id}")
    public Result doDelete(@PathVariable("id") Long id){
        Result result = new Result();
        int i = appVersionService.deleteByPrimaryKey(id);
        if (i>0){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }
}
