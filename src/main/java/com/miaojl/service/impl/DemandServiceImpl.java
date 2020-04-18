package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.DemandMapper;
import com.miaojl.entity.Demand;
import com.miaojl.service.DemandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/11
 * @description 需求服务层
 */
@Service
@Transactional
public class DemandServiceImpl extends BaseServiceImpl<Demand> implements DemandService {

    @Override
    public PageInfo<Demand> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Demand demand = new Demand();
        demand.setDelFlag("0");
        List<Demand> demands = mapper.select(demand);
        return new PageInfo<Demand>(demands);
    }

}
