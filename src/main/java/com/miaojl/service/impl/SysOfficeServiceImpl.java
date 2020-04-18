package com.miaojl.service.impl;

import com.miaojl.entity.SysOffice;
import com.miaojl.service.BaseService;
import com.miaojl.service.SysOfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mjl
 * @date 2020/4/14
 * @description 企业机构
 */
@Service
@Transactional
public class SysOfficeServiceImpl extends BaseServiceImpl<SysOffice> implements SysOfficeService {
}
