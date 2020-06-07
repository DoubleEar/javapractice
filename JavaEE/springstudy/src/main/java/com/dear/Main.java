package com.dear;

import com.dear.model.Duck;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
        Duck duck1=(Duck)context.getBean("duck1");
        Duck duck2=(Duck) context.getBean("duck2");

        System.out.println(duck1);
        System.out.println(duck2);
    }
}
