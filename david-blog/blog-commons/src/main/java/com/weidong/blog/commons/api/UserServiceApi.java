package com.weidong.blog.commons.api;

import com.weidong.blog.commons.entity.BlogUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserServiceApi
 * @Description 用户相关信息
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 20:43
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
@FeignClient("blog-static-service")
public interface UserServiceApi {

    /**
     * 添加用户
     * @param blogUser
     * @return
     */
    @PostMapping("/UserServiceApi/insertUser")
    int insertUser(@RequestBody BlogUser blogUser);

    /**
     * 根据ID获取用户
     * @param userId
     * @return
     */
    @GetMapping("/UserServiceApi/getUserById")
    BlogUser getUserById(@RequestParam(value = "userId") String userId);

    /**
     * 根据手机号获取用户
     * @param phoneNum
     * @return
     */
    @GetMapping("/UserServiceApi/getUserByPhoneNum")
    BlogUser getUserByPhoneNum(@RequestParam(value = "phoneNum") String phoneNum);

    /**
     * 根据ID更新用户
     * @param blogUser
     * @return
     */
    @PostMapping("/UserServiceApi/updateUserById")
    int updateUserById(@RequestBody BlogUser blogUser);

    /**
     * 用户登录
     * @param blogUser
     * @return
     */
    BlogUser Login(@RequestBody BlogUser blogUser);

}
