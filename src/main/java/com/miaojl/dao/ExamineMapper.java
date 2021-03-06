package com.miaojl.dao;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.Examine;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ExamineMapper extends Mapper<Examine> {

    @SelectProvider(type=ExamineSqlProvider.class, method="selectByCondition")
    List<Examine> selectByCondition(Map<String, Object> params);
}