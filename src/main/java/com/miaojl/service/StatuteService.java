package com.miaojl.service;


import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Statute;

public interface StatuteService extends  BaseService<Statute> {


    PageInfo<Statute> selectPage(int pageNum, int pageSize, Integer type);

}
