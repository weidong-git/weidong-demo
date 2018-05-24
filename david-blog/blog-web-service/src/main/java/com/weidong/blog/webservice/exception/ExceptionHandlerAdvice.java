package com.weidong.blog.webservice.exception;

import com.weidong.blog.commons.exception.EnhanceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ExceptionHeader
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 12:04
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@ControllerAdvice
public class ExceptionHandlerAdvice {
    public static final String DEFAULT_ERROR_VIEW = "error/exception";

    @ExceptionHandler(value = EnhanceException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req , Throwable throwable) throws Exception {
        System.out.println("进入了视图方法");
        throwable.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", throwable);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("msg",throwable.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
