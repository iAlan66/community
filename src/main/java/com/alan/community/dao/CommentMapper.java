package com.alan.community.dao;

import com.alan.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/5 17:31
 */
@Mapper
public interface CommentMapper {

    // 根据实体查询评论
    List<Comment> selectCommentsByEntity(int entityType,int entityId, int offset, int limit);

    // 查询评论总数
    int selectCountByEntity(int entityType, int entityId);

    // 增加评论
    int insertComment(Comment comment);

    // 根据id查comment
    Comment selectCommentById(int id);
}
