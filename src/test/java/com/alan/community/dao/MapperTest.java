package com.alan.community.dao;

import com.alan.community.NowcoderCommunityApplication;
import com.alan.community.entity.DiscussPost;
import com.alan.community.entity.LoginTicket;
import com.alan.community.entity.Message;
import com.alan.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/19 20:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NowcoderCommunityApplication.class)
class MapperTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Test
    void selectDiscussPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        list.forEach(System.out::println);
    }

    @Test
    void selectDiscussPostRows() {
        int i = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(i);
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(11);
        System.out.println(user);
    }

    @Test
    void insertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(10);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis()+ 1000 * 60 *10) );
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    void selectByTicket() {
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    void updateStatus() {
        int abc = loginTicketMapper.updateStatus("abc",1);
    }

    @Test
    void selectConversations() {
        List<Message> messages = messageMapper.selectConversations(111, 0, 10);
        for (Message message:messages){
            System.out.println(message);
        }
    }

    @Test
    void selectConversationCount() {
        int i = messageMapper.selectConversationCount(111);
        System.out.println(i);
    }

    @Test
    void selectLetters() {
        List<Message> messages = messageMapper.selectLetters("111_112", 0, 10);
        for (Message message : messages) {
            System.out.println(message);
        }

    }

    @Test
    void selectLetterCount() {
        int i = messageMapper.selectLetterCount("111_112");
        System.out.println(i);
    }

    @Test
    void selectLetterUnreadCount() {
        int i = messageMapper.selectLetterUnreadCount(111, "111_112");
        System.out.println(i);
    }
}