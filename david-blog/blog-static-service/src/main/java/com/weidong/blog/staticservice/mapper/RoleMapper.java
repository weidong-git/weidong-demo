package com.weidong.blog.staticservice.mapper;

import com.weidong.blog.commons.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    /**
     * 角色添加
     * @param role
     * @return
     */
    int insert(Role role);
}
