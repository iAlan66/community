package com.alan.community.service;

import com.alan.community.dao.DiscussPostMapper;
import com.alan.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/20 1:57
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> finDiscussPosts(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
