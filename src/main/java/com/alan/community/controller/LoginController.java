package com.alan.community.controller;

import com.alan.community.entity.User;
import com.alan.community.service.UserService;
import com.alan.community.util.CommunityConstant;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/23 1:16
 */
@Controller
public class LoginController implements CommunityConstant {

    @Autowired
    private UserService userService;

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegisterPage(){
        return "/site/register";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginPage(){
        return "/site/login";
    }

    /**
     * 提交注册表单
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model, User user){
        Map<String, Object> map = userService.register(user);
        if (map == null || map.isEmpty()){
            model.addAttribute("msg","注册成功，我们已经向您的邮箱发送了一封激活邮件");
            model.addAttribute("target","/index");
            return "/site/operate-result";
        }else{
            model.addAttribute("usernameMsg", map.get("usernameMsg"));
            model.addAttribute("passwordMsg", map.get("passwordMsg"));
            model.addAttribute("emailMsg", map.get("emailMsg"));
            return "/site/register";

        }
    }

    /**
     * 激活链接跳转
     * @param model
     * @param userId
     * @param code
     * @return
     */
    //http://localhost:8080/community/activation/101/code
    @RequestMapping(path = "/activation/{userId}/{code}" ,method = RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId,@PathVariable("code") String code){
        int result = userService.activation(userId, code);
        if (result == ACTIVATION_SUCCESS){
            model.addAttribute("msg","激活成功，帐号可以使用");
            model.addAttribute("target","/login");
        }else if(result == ACTIVATION_REPEAT){
            model.addAttribute("msg","无效操作");
            model.addAttribute("target","/index");

        }else {
            model.addAttribute("msg","激活失败，激活码不正确");
            model.addAttribute("target","/index");

        }
        return "/site/operate-result";
    }
}
