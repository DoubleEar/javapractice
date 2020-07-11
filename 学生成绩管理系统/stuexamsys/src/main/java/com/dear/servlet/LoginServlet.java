package com.dear.servlet;
//用户登录的servlet处理
import com.dear.dao.UserDAO;
import com.dear.model.User;
import com.dear.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析http请求的用户名密码
        User user=JSONUtil.read(req.getInputStream(),User.class);
        //根据用户名密码查询用户
        User queryUser=UserDAO.query(user);

        if(queryUser==null)     //没有结果集
            throw new RuntimeException("用户名密码校验失败");

        HttpSession httpSession=req.getSession();
        httpSession.setAttribute("user",queryUser);
        return null;
    }
}

