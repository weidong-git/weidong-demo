package com.weidong.blog.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName ViewController
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 21:31
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@Controller
public class ViewController {

    /** 
     * 返回页面
     * @author weidong
     * @Description: 
     * @Param 
     * @Throws
     * @Date 2018/5/20 21:33 
     * @return 
     **/
    @RequestMapping(value = "/view/{viewName}")
    public ModelAndView restultView(@PathVariable String viewName){
        System.out.println("试图="+viewName);
        viewName = viewName.replaceAll("\\-","/");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
