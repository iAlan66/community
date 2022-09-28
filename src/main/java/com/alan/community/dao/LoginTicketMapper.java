package com.alan.community.dao;

import com.alan.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/9/28 13:25
 */
@Mapper
public interface LoginTicketMapper {

    //添加登录凭证
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    // 根据登录凭证查询登录用户
    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    // 更新登录状态
    @Update({
            "<script>",
            "update login_ticket set status=#{status} ",
            "where ticket=#{ticket}",
            "</script>"
    })
    int updateStatus(String ticket, int status);

}
