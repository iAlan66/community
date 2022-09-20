package com.alan.community.service;

import com.alan.community.dao.UserMapper;
import com.alan.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/20 2:06
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserByid(int id){
        return userMapper.selectById(id);
    }
}
