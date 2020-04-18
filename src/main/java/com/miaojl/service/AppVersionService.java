package com.miaojl.service;

import com.github.pagehelper.PageInfo;
import com.miaojl.entity.AppVersion;

public interface AppVersionService extends BaseService<AppVersion> {
    PageInfo<AppVersion> selectPage(int pageNum, int pageSize);
}
