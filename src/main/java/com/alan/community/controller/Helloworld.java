package com.alan.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/19 11:43
 */
@Controller
public class Helloworld {

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello";
    }
}
