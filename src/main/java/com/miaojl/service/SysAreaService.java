package com.miaojl.service;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.SysArea;

public interface SysAreaService extends BaseService<SysArea> {
    PageInfo<SysArea> selectPage(int pageNum, int pageSize);
}
