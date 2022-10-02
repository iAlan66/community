package com.alan.community.util;

import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.Map;
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

    //
    public static String getJSONString(int code, String msg, Map<String ,Object> map){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        
        if (map != null){
            for (String key : map.keySet()) {
                json.put(key,map.get(key));
            }
        }
        return json.toString();
    }
    //
    public static String getJSONString(int code, String msg){
        return getJSONString(code,msg,null);
    }
    //
    public static String getJSONString(int code){
        return getJSONString(code,null,null);
    }
}
