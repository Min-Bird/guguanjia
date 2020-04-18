package com.miaojl.controller;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.WorkOrder;
import com.miaojl.entity.Result;
import com.miaojl.service.DetailService;
import com.miaojl.service.TransferService;
import com.miaojl.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mjl
 * @date 2020/4/14
 * @description 考核控制器
 */
@RestController
@RequestMapping("manager/work")
public class WorkOrderController {

    @Autowired
    WorkOrderService workOrderService;

    @Autowired
    DetailService detailService;

    @Autowired
    TransferService transferService;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("work/admin/index");
    }
    @RequestMapping("toDetail")
    public ModelAndView toDetail(){
        return new ModelAndView("work/work-detail");
    }

    @RequestMapping(value = "selectPage/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public Result selectPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,@RequestBody Map<String,Object> params){
        PageInfo<WorkOrder> pageInfo = workOrderService.selectPage(pageNum, pageSize,params);
        return new Result(true,"查询成功",pageInfo);
    }

    @RequestMapping(value = "doDetail/{id}",method = RequestMethod.PUT)
    public Result doDetail(@PathVariable("id") int id){
        Map<String,Object> result = new HashMap<>();
        result.put("details",detailService.selectByWorkId(id));
        result.put("transfers",transferService.selectByWorkId(id));
        return new Result(true,"查询成功",result);
    }


    
}
