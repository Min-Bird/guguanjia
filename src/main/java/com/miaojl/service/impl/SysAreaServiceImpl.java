package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.SysAreaMapper;
import com.miaojl.entity.SysArea;
import com.miaojl.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/18
 * @description 区域服务
 */
@Service
@Transactional
public class SysAreaServiceImpl extends BaseServiceImpl<SysArea> implements SysAreaService {

    @Autowired
    SysAreaMapper sysAreaMapper;

    @Override
    public PageInfo<SysArea> selectPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<SysArea> sysAreas = sysAreaMapper.selectAll();
        return new PageInfo<>(sysAreas);
    }

}
