package com.weidong.mapper;

import com.weidong.entity.BlogUser;
import com.weidong.entity.BlogUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogUserMapper {
    /**
     *
     * @mbg.generated 2018-05-22
     */
    long countByExample(BlogUserExample example);

    /**
     *
     * @mbg.generated 2018-05-22
     */
    int deleteByExample(BlogUserExample example);

    /**
     *
     * @mbg.generated 2018-05-22
     */
    int insert(BlogUser record);

    /**
     *
     * @mbg.generated 2018-05-22
     */
    int insertSelective(BlogUser record);

    /**
     *
     * @mbg.generated 2018-05-22
     */
    List<BlogUser> selectByExample(BlogUserExample example);

    /**
     *
     * @mbg.generated 2018-05-22
     */
    int updateByExampleSelective(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    /**
     *
     * @mbg.generated 2018-05-22
     */
    int updateByExample(@Param("record") BlogUser record, @Param("example") BlogUserExample example);
}