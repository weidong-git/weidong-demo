package com.weidong.blog.staticservice.api;

import com.weidong.blog.commons.api.UserServiceApi;
import com.weidong.blog.commons.entity.BlogUser;
import com.weidong.blog.staticservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserApiImpl
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 21:03
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@RestController
public class UserApiImpl implements UserServiceApi {

    @Autowired
    private UserService userService;
    @Override
    public int insertUser(@RequestBody BlogUser blogUser) {
        return userService.insertUser(blogUser);
    }

    @Override
    public BlogUser getUserById(String userId) {
        return userService.getUserById(userId);
    }

    @Override
    public BlogUser getUserByPhoneNum(String phoneNum) {
        return userService.getUserById(phoneNum);
    }

    @Override
    public int updateUserById(@RequestBody BlogUser blogUser) {
        return userService.updateUserById(blogUser);
    }
}
