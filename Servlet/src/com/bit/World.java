package com.bit;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class World extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 返回的状态是 200
        resp.setStatus(200);
        // 2. 返回的响应体是 html 格式
        // 3. 返回的响应体是 utf-8
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        // 4. 响应体 <h1>你好世界</h1>
        //ServletOutputStream outputStream = resp.getOutputStream(); // 写非文本格式的响应体
        PrintWriter writer = resp.getWriter();  // 文本格式的响应体

        writer.println("<h1>你好世界</h1>");
    }
}
