package com.weidong.blog.webservice.service;

import com.weidong.blog.commons.api.UserServiceApi;
import com.weidong.blog.commons.entity.BlogUser;
import com.weidong.blog.commons.until.Checker;
import com.weidong.blog.commons.until.RequestUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassName SessionAuthService
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/22 22:44
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@Service
public class SessionAuthService {

    @Autowired
    private UserServiceApi userServiceApi;

    /**
     * 登录
     * @param phoneNum
     * @param request
     */
    public void login(String phoneNum, HttpServletRequest request){
        Checker.require(StringUtils.isNotEmpty(phoneNum),"用户手机号不能为空");
        BlogUser user = this.userServiceApi.getUserByPhoneNum(phoneNum);
        Checker.require(user != null,"用户不存在，登录失败");
        String thisIp = RequestUtil.getClientIp(request);
        user.setLastIp(user.getThisIp());
        user.setLastTime(user.getThisTime());
        user.setThisIp(thisIp);
        user.setThisTime(new Date());
        //更新用户
        userServiceApi.updateUserById(user);
        //设置session
        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_USER",user);
    }
}
