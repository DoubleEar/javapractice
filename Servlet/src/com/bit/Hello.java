package com.bit;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            String method = req.getMethod();
            System.out.println("请求方法："+method);
        }

        {
            String requestURI = req.getRequestURI();
            System.out.println("完整的路径："+requestURI);
            String servletPath = req.getServletPath();
            System.out.println("除去Context Path的路径"+servletPath);
            String contextPath = req.getContextPath();
            System.out.println("Context Path"+contextPath);
        }

        {
            //获取查询语句
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()){
                String key=parameterNames.nextElement();
                String value=req.getParameter(key);
                System.out.println(key+"="+value);
            }
        }

        {
            //获取协议号
            String protocol = req.getProtocol();
            System.out.println("协议号："+protocol);
        }

        {
            //获取请求头
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = req.getHeader(key);
                System.out.println("Header: " + key + " = " + value);
            }
        }

        {
            ServletInputStream inputStream = req.getInputStream();
            // 通过读取 inputStream 来获取 Body 部分的内容
        }
    }
}
