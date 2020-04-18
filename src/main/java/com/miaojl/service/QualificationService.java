package com.miaojl.service;

import com.github.pagehelper.PageInfo;

import com.miaojl.entity.Qualification;
import com.miaojl.entity.QualificationCondition;

public interface QualificationService extends BaseService<Qualification> {

    PageInfo<Qualification> selectPage(int pageNum, int pageSize, QualificationCondition condition);

}
