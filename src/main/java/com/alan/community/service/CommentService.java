package com.alan.community.service;

import com.alan.community.dao.CommentMapper;
import com.alan.community.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/5 17:49
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    // 根据类型查询评论
    public List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit){
        return commentMapper.selectCommentsByEntity(entityType,entityId,offset,limit);
    }

    // 查询评论总条数
    public int findCommentCount(int entityType, int entityId){
        return commentMapper.selectCountByEntity(entityType,entityId);
    }
}
