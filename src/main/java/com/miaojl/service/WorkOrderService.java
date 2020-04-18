package com.miaojl.service;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.WorkOrder;

import java.util.Map;

public interface WorkOrderService extends BaseService<WorkOrder> {
    PageInfo<WorkOrder> selectPage(int pageNum, int pageSize, Map<String, Object> params);
}
