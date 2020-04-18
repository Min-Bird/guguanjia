package com.miaojl.controller;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Demand;
import com.miaojl.entity.Result;
import com.miaojl.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author mjl
 * @date 2020/4/11
 * @description 服务需求控制器
 */
@RestController
@RequestMapping("manager/demand")
public class DemandController {

    @Autowired
    DemandService demandService;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("demand/index");
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate(){
        return new ModelAndView("demand/update");
    }

    @RequestMapping("toDetail")
    public ModelAndView toDetail(){
        return new ModelAndView("demand/detail");
    }

    @RequestMapping("selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        PageInfo<Demand> pageInfo = demandService.selectPage(pageNum,pageSize);
        return new Result(true,"成功",pageInfo);
    }

    @RequestMapping("doUpdate")
    public Result doUpdate(@RequestBody Demand demand){
        demand.setDelFlag("0");
        demand.setCreateDate(new Date());
        //TODO 创建人
        demand.setCreateBy("2");
        int i = demandService.updateByPrimaryKeySelective(demand);
        Result result = new Result();
        if (i>0){
            result.setSuccess(true);
            result.setMsg("更新成功");
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
