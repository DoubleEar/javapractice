package com.dear;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dear.mapper")   //启动类指定需要扫描的接口包路径
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
