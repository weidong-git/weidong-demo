package com.weidong.blog.staticservice.service;

import com.weidong.blog.commons.entity.BlogUser;
import com.weidong.blog.commons.until.Checker;
import com.weidong.blog.commons.until.UUIDUtil;
import com.weidong.blog.staticservice.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 21:05
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public  int insertUser(BlogUser blogUser){
        Checker.require(StringUtils.isNotEmpty(blogUser.getPhoneNum()),"手机号不能为空");
        Checker.require(StringUtils.isNotEmpty(blogUser.getPassword()),"密码不能为空");
        blogUser.setCreateTime(new Date());
        String salt = BCrypt.gensalt(8);
        String hasedPwd = BCrypt.hashpw(blogUser.getPassword(),salt);
        blogUser.setPassword(hasedPwd);
        blogUser.setPwdSalt(salt);
        blogUser.setId(UUIDUtil.getUUID());
        return userMapper.insert(blogUser);
    }


    public BlogUser getUserById(String id){
        return userMapper.getUserById(id);
    }

    public  int updateUserById(BlogUser blogUser){
       return userMapper.updateUserById(blogUser);
    }

}
