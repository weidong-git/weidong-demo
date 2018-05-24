package com.weidong.blog.webservice.controller;

import com.weidong.blog.commons.entity.Role;
import com.weidong.blog.commons.api.RoleServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleServiceApi roleServiceApi;

    @RequestMapping("/insert")
    public int insertRole(Role role){
        return roleServiceApi.insert(role);
    }
}
