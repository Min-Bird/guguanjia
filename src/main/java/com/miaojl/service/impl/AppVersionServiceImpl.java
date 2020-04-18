package com.miaojl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaojl.dao.AppVersionMapper;
import com.miaojl.entity.AppVersion;
import com.miaojl.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mjl
 * @date 2020/4/9
 * @description AppVersion业务逻辑层
 */
@Service
@Transactional
public class AppVersionServiceImpl extends BaseServiceImpl<AppVersion> implements AppVersionService {

    @Autowired
    AppVersionMapper appVersionMapper;

    @Override
    public PageInfo<AppVersion> selectPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
//        List<AppVersion> appVersions = mapper.selectAll();
        AppVersion appVersion = new AppVersion();
        appVersion.setDelFlag("0");
        List<AppVersion> appVersions = appVersionMapper.select(appVersion);
        return new PageInfo<AppVersion>(appVersions);
    }

}
