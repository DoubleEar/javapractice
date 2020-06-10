package com.dear.controller;

import com.dear.moudel.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(Integer i){
        if(i==1)
            return "redirect:/index.html";
        else
            return "forward:/index.html";

    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam("username")String username1,
                                                  String password,
                                                  String password2){
        System.out.println(username1+"="+password+"="+password2);
        User user = new User();
        user.setUsername("耳耳");
        user.setPassword("123456");
        user.setBirthday(new Date());

        return user;
    }

    @RequestMapping(value = "/login3",method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User u){
        User user = new User();
        user.setUsername("早耶");
        user.setPassword("123456");
        user.setBirthday(new Date());

        return user;
    }

    @RequestMapping(value = "/login4",method = RequestMethod.POST)
    @ResponseBody
    public Object login4(@RequestBody User u){
        User user = new User();
        user.setUsername("大白鹅");
        user.setPassword("123789");
        user.setBirthday(new Date());

        return user;
    }

    @RequestMapping(value = "/login5",method = RequestMethod.POST)
    @ResponseBody
    public Object login5(HttpServletRequest req, HttpServletResponse resp,
                         @RequestBody User u){
            if("abc".equals(u.getUsername())&&"123".equals(u.getPassword())){
                HttpSession httpSession=req.getSession();
                httpSession.setAttribute("user",u);
                User user = new User();
                user.setUsername("Justin");
                user.setPassword("789");
                user.setBirthday(new Date());
                return user;
            }

            throw new RuntimeException("登陆失败");
    }

}
