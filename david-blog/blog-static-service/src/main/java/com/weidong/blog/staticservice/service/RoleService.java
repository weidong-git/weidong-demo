package com.weidong.blog.staticservice.service;

import com.weidong.blog.commons.entity.Role;
import com.weidong.blog.staticservice.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 角色添加
     * @param role
     * @return
     */
    public int insert(Role role){
        return  roleMapper.insert(role);
    }


}
