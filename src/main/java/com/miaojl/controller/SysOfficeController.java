package com.miaojl.controller;

import com.miaojl.entity.Result;
import com.miaojl.service.SysOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mjl
 * @date 2020/4/14
 * @description 企业机构
 */
@RestController
@RequestMapping("manager/office")
public class SysOfficeController {

    @Autowired
    SysOfficeService service;

    @RequestMapping("list")
    public Result list(){
        return new Result(true,"查询成功",service.selectAll());
    }
}
