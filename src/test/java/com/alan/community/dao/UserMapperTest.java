package com.alan.community.dao;

import com.alan.community.NowcoderCommunityApplication;
import com.alan.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/23 3:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NowcoderCommunityApplication.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectById() {

    }

    @Test
    void selectByName() {
        User user = userMapper.selectByName("SYSTEM");
        System.out.println(user);
    }

    @Test
    void selectByEmail() {
        User user = userMapper.selectByEmail("nowcoder117@sina.com");
        System.out.println(user);
    }
}