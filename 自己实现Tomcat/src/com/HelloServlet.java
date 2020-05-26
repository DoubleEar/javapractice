package com;

import standard.HttpServlet;
import standard.HttpServletRequest;
import standard.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    //一定晚于new，早于process之前
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("你好世界");
    }
}
