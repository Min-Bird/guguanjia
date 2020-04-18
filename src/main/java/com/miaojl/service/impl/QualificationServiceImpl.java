package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.QualificationMapper;
import com.miaojl.entity.Qualification;
import com.miaojl.entity.QualificationCondition;
import com.miaojl.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/13
 * @description 审核服务
 */
@Service
@Transactional
public class QualificationServiceImpl extends BaseServiceImpl<Qualification> implements QualificationService {

    @Autowired
    QualificationMapper qualificationMapper;

    @Override
    public PageInfo<Qualification> selectPage(int pageNum, int pageSize, QualificationCondition condition) {
        PageHelper.startPage(pageNum,pageSize);
        List<Qualification> qualifications = qualificationMapper.selectByCondition(condition);
        return new PageInfo<Qualification>(qualifications);
    }
}
