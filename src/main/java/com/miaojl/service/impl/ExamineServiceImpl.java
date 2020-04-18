package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.ExamineMapper;
import com.miaojl.entity.Examine;
import com.miaojl.service.BaseService;
import com.miaojl.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author mjl
 * @date 2020/4/14
 * @description 考核服务
 */
@Service
@Transactional
public class ExamineServiceImpl extends BaseServiceImpl<Examine> implements ExamineService {

    @Autowired
    ExamineMapper mapper;

    public PageInfo<Examine> selectPage(int pageNum, int pageSize, Map<String, Object> params){

        PageHelper.startPage(pageNum,pageSize);
        Examine examine = new Examine();
        examine.setDelFlag("0");
        List<Examine> examines = mapper.selectByCondition(params);
        return new PageInfo<Examine>(examines);
    }

}
