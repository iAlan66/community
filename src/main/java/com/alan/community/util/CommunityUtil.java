package com.alan.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/23 2:35
 */
public class CommunityUtil {

    // 生成随机字符串，将“-”替换为“”
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //MD5 加密
    //将传入的 key 加密成 16 进制的数
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
