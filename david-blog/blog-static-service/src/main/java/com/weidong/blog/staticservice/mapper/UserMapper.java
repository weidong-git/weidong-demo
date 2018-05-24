package com.weidong.blog.staticservice.mapper;

import com.weidong.blog.commons.entity.BlogUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insert(BlogUser blogUser);

    BlogUser getUserById(String id);

    int updateUserById(BlogUser blogUser);
}
