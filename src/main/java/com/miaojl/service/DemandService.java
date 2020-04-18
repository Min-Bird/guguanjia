package com.miaojl.service;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Demand;

public interface DemandService extends BaseService<Demand>{
    PageInfo<Demand> selectPage(int pageNum, int pageSize);
}
