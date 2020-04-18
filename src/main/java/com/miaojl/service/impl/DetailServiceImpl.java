package com.miaojl.service.impl;

import com.miaojl.dao.DetailMapper;
import com.miaojl.entity.Detail;
import com.miaojl.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/16
 * @description 转运详单
 */
@Service
@Transactional
public class DetailServiceImpl extends BaseServiceImpl<Detail> implements DetailService {

    @Autowired
    DetailMapper detailMapper;


    @Override
    public List<Detail> selectByWorkId(Integer id) {
        return detailMapper.selectByWorkId(id);
    }
}
