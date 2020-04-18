package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.StatuteMapper;
import com.miaojl.entity.Statute;
import com.miaojl.service.StatuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatuteServiceImpl extends BaseServiceImpl<Statute> implements StatuteService {


    @Autowired
    StatuteMapper statuteMapper;  //从父类型BaseServiceImpl继承过来的 mapper是一个对象


    @Override
    public PageInfo<Statute> selectPage(int pageNum, int pageSize,Integer type){
        PageHelper.startPage(pageNum,pageSize);//开启分页拦截
        Statute statute = new Statute();
        statute.setType(type);
        List<Statute> statutes = statuteMapper.select(statute);

        return new PageInfo<Statute>(statutes);
    }


}
