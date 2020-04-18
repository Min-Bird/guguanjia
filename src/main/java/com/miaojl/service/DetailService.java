package com.miaojl.service;

import com.miaojl.entity.Detail;

import java.util.List;

public interface DetailService extends BaseService<Detail>{
    List<Detail> selectByWorkId(Integer id);
}
