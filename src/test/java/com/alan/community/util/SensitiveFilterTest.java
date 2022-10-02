package com.alan.community.util;

import com.alan.community.NowcoderCommunityApplication;
import org.junit.After;
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
 * @date 2022/10/2 2:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NowcoderCommunityApplication.class)
class SensitiveFilterTest {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    void filter() {

        String s = sensitiveFilter.filter("你好赌博");
        System.out.println(s);
    }
}