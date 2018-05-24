package com.weidong.blog.webservice.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ErrorsController
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 12:39
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@Controller
public class ErrorsController implements ErrorController {

    @RequestMapping("/error")
    public String error(){
        System.out.println("进到这里了");
        return "error/server-error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
