package standard;

import java.io.IOException;

public abstract class HttpServlet implements Servlet {
    @Override
    public void process(ServletRequest req, ServletResponse resp) throws IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String method = httpReq.getMethod();
        switch (method) {
            case "GET": doGet(httpReq, (HttpServletResponse)resp); break;
            case "POST": doPost(httpReq, (HttpServletResponse)resp); break;
            default:
                throw new RuntimeException(method);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 405 Method Not Allowed
        resp.setStatus(405);
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().println("不支持的方法");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 405 Method Not Allowed
        resp.setStatus(405);
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().println("不支持的方法");
    }
}
