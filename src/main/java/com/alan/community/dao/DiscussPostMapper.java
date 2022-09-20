package com.alan.community.dao;

import com.alan.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/19 14:11
 */
@Mapper
public interface DiscussPostMapper {

    /**
     * 展示评论数据
     * @param userId
     * @param offset 起始行号
     * @param limit 每页显示的数据数量
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);


    /**
     * 查询数据总行数
     * @param userId
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);


}
