package com.alan.community;

import com.alan.community.util.CommunityUtil;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/20 11:33
 */
public class myTest {

    @Test
    public void listAndMap(){
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("post",i++);
            map.put("user",i--);
            list.add(map);
        }
        list.forEach(System.out::println);
    }

    @Test
    public void testJson(){
        Map<String, Object> map = new HashMap<>();
        map.put("age", 10);
        map.put("name", "alan");
        System.out.println(CommunityUtil.getJSONString(0,"ok",map));
    }
}
