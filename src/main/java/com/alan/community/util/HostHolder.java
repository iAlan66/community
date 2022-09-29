package com.alan.community.util;

import com.alan.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/29 22:07
 * 持有用户信息，用于代替session对象
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }
}
