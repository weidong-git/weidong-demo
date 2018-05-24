package com.weidong.blog.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MyWebMvcConfigurerAdapter
 * @Description 静态资源拦截器
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 10:16
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }
}
