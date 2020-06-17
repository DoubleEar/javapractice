package com.dear.config;

import com.dear.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration  //统一的拦截器
public class MyConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginInterceptor()) //所有匹配的路径，都会进入拦截器
                    .addPathPatterns("/1/**") //**代表所有子路径，*只匹配一级路径 添加路径
                    .excludePathPatterns("/1/login5");    //排除此路径
    }

    @Bean
    public User user1(){    //定义了一个方法名为user1的Bean对象，并注册到容器中。
        User user=new User();
        user.setUsername("大笨猪");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @Bean
    public User user2(@Qualifier("user1") User user1){
        User user=new User();
        user.setUsername("jkl");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
