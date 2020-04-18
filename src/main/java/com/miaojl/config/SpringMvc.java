package com.miaojl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author mjl
 * @date 2020/4/7
 * @description mvc配置
 */
@Controller
@EnableWebMvc //开启mvc注解支持
@ComponentScan(basePackages = "com.miaojl.controller")
public class SpringMvc implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //开启静态资源放行
        configurer.enable();
    }

    //自定义视图解析器
    @Bean
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/html/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    //文件上传解析器
    @Bean("multipartResolver")
    public CommonsMultipartResolver getMultipartResolver(){
        return new CommonsMultipartResolver();
    }
}
