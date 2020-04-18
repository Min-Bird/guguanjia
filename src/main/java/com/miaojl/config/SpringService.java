package com.miaojl.config;

/**
 * @author mjl
 * @date 2020/4/7
 * @description spring整合事务
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * spring整合服务层设置:
 * 1.扫描服务层
 * 2.声明事务处理器
 * 3.开启事务注解支持
 * 4.在服务层加入事务注解
 */
@Configuration
@ComponentScan(basePackages = "com.miaojl.service")
@EnableTransactionManagement
public class SpringService {

    @Bean
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
