package com.miaojl.service;

import com.miaojl.entity.Transfer;

import java.util.List;

public interface TransferService extends BaseService<Transfer> {
    List<Transfer> selectByWorkId(Integer id);
}
