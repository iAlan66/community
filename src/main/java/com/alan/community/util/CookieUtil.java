package com.alan.community.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/29 18:33
 *
 */
public class CookieUtil {

    // 在request中获取指定cookie的值
    public static String getValue(HttpServletRequest request,String name){
        if (request == null || name == null){
            throw new IllegalArgumentException();
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
