package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.WorkOrderMapper;
import com.miaojl.entity.WorkOrder;
import com.miaojl.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author mjl
 * @date 2020/4/15
 * @description 工作单
 */
@Service
@Transactional
public class WorkOrderServiceImpl extends BaseServiceImpl<WorkOrder> implements WorkOrderService {
    @Autowired
    WorkOrderMapper mapper;

    public PageInfo<WorkOrder> selectPage(int pageNum, int pageSize, Map<String, Object> params){
        PageHelper.startPage(pageNum,pageSize);
        List<WorkOrder> workOrders = mapper.selectByCondition(params);
        return new PageInfo<WorkOrder>(workOrders);
    }
}
