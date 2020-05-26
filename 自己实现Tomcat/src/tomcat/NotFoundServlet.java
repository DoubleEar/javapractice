package tomcat;

import standard.HttpServlet;
import standard.HttpServletRequest;
import standard.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class NotFoundServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        print404(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        print404(req,resp);
    }

    private void print404(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(404);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        writer.println("<h1>HTTP Status 404 – 未找到</h1>");
        writer.println("<p><strong>Type</strong> Status Report</p>");
        writer.println("<p><strong>消息</strong> " + req.getPath() + "</p>");
        writer.println("<p><strong>描述</strong> 源服务器未能找到目标资源的表示或者是不愿公开一个已经存在的资源表示。</p>");
        writer.println("<p>Tomcat 0.0.1</p>");
    }
}
