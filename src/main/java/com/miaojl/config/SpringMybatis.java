package com.miaojl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.util.Properties;

/**
 * spring整合mybatis配置
 * 1.数据源配置
 * 2.sqlSessionFactoryBean配置
 * 3.扫描mapper配置
 * @author mjl
 * @date 2020/4/7
 * @description mybatis控制文件
 */
@Configuration
@MapperScan(basePackages = "com.miaojl.dao")
@PropertySource(value = "classpath:sys.properties",encoding = "utf-8")
@Import(SpringService.class)
public class SpringMybatis {

    @Bean
    public DruidDataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();

        Properties properties = new Properties();
        try {
            properties.load(SpringMybatis.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        druidDataSource.configFromPropety(properties);//自动加载配置属性
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean getFactoryBean(DruidDataSource druidDataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);

        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        //设置输出日志对象
        configuration.setLogImpl(Log4j2Impl.class);
        //开启驼峰命名
        configuration.setMapUnderscoreToCamelCase(true);

        sqlSessionFactoryBean.setConfiguration(configuration);

//        添加分页插件
        PageInterceptor interceptor = new PageInterceptor();
        interceptor.setProperties(new Properties());
        sqlSessionFactoryBean.setPlugins(interceptor);

        return sqlSessionFactoryBean;
    }

}
