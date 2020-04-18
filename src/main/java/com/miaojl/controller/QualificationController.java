package com.miaojl.controller;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.AppVersion;
import com.miaojl.entity.Qualification;
import com.miaojl.entity.QualificationCondition;
import com.miaojl.entity.Result;
import com.miaojl.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author mjl
 * @date 2020/4/13
 * @description 资质审核
 */
@RestController
@RequestMapping("manager/qualification")
public class QualificationController {

    @Autowired
    QualificationService qualificationService;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("qualification/index");
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        return new ModelAndView("qualification/update");
    }

    @RequestMapping("selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize, QualificationCondition condition){
        PageInfo<Qualification> pageInfo = qualificationService.selectPage(pageNum, pageSize,condition);
        return new Result(true,"成功",pageInfo);
    }

    @RequestMapping(value = "doUpdate",method = RequestMethod.PUT)
    public Result doUpdate(@RequestBody Qualification qualification){
        Result result = new Result();
        qualification.setUpdateDate(new Date());
        int i = qualificationService.updateByPrimaryKeySelective(qualification);
        if(i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }else{
            result.setMsg("更新失败");
        }
        return result;
    }
}
