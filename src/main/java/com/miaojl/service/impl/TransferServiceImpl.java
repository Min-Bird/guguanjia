package com.miaojl.service.impl;

import com.miaojl.dao.TransferMapper;
import com.miaojl.entity.Transfer;
import com.miaojl.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/16
 * @description 运输详单
 */

@Service
@Transactional
public class TransferServiceImpl extends BaseServiceImpl<Transfer> implements TransferService {

    @Autowired
    TransferMapper transferMapper;

    @Override
    public List<Transfer> selectByWorkId(Integer id) {
        return transferMapper.selectByWorkId(id);
    }
}
