package com.weidong.blog.staticservice.api;

import com.weidong.blog.commons.entity.Role;
import com.weidong.blog.commons.api.RoleServiceApi;
import com.weidong.blog.staticservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleAipImpl implements RoleServiceApi {

    @Autowired
    private RoleService roleService;

    /**
     * 角色添加
     * @param role
     * @return
     */
    @Override
    public int insert(Role role) {
        return roleService.insert(role);
    }


}
