package com.weidong.blog.webservice.exception;

import com.weidong.blog.commons.exception.EnhanceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RestExceptionAdvice
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 13:11
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@RestControllerAdvice(annotations = ResponseBody.class)
public class RestExceptionAdvice {

    @ExceptionHandler(value = EnhanceException.class)
    @ResponseBody
    public Map<String,Object> hanlde(Throwable throwable){
        System.out.println("请求了/json");
        Map<String,Object> ret = new HashMap<>();
        ret.put("code",5000);
        ret.put("msg",throwable.getMessage());
        return ret;
    }
}
