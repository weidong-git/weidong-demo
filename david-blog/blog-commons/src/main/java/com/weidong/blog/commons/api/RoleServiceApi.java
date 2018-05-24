package com.weidong.blog.commons.api;

import com.weidong.blog.commons.entity.Role;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("blog-static-service")
public interface RoleServiceApi {

    /**
     * 添加角色
     */
    @GetMapping(value = "/role/insert")
    int insert(Role role);

}
