package com.alan.community.controller;

import com.alan.community.entity.DiscussPost;
import com.alan.community.entity.Page;
import com.alan.community.entity.User;
import com.alan.community.service.DiscussPostService;
import com.alan.community.service.LikeService;
import com.alan.community.service.UserService;
import com.alan.community.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/20 2:41
 */
@Controller
public class HomeController implements CommunityConstant {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){

        page.setRows(discussPostService.findDiscussRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.finDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null){
            for (DiscussPost post: list){
                Map<String, Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);

                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount",likeCount);

                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
//        model.addAttribute("page",page);//方法调用之前，SpringMVC会自动实例化Model和page，这个可以省略
        return "index";
    }

    // error
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String getErrorPage(){
        return "/error/500";
    }
}
