package com.miaojl.service;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Examine;

import java.util.Map;

public interface ExamineService extends BaseService<Examine>{
    PageInfo<Examine> selectPage(int pageNum, int pageSize, Map<String, Object> map);
}
