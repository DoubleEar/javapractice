package com.dear.filter;
//登录拦截处理
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //进行处理
     @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req=(HttpServletRequest)request;
         HttpServletResponse resp=(HttpServletResponse)response;
         //判断是否是敏感资源，如果是，获取session，如果获取不到，就重定向到登陆页面。
         String uri=req.getServletPath();
         if(!uri.startsWith("/public/")&&!uri.startsWith("/static/")&&!"/user/login".equals(uri)){
             //获取session
             HttpSession session=req.getSession(false); //不自动创建
             if(session==null){     //没有登录，不允许访问。
                 //假如是相对路径的重定向：假设请求路径为/ses/exam/query
                 //resp.sendRedirect("public/index.html"); 会跳转到/ses/exam/query/public/index.html
                 //resp.sendRedirect("/public/index.html"); 会跳转到/public/index.html

                 //必须使用绝对路径进行跳转
                 String scheme = req.getScheme();   //http
                 String host= req.getServerName();  //服务器ip
                 int port = req.getServerPort();    //服务器端口号
                 String contextPath = req.getContextPath(); //获取项目部署名
                 String basePath=scheme+"://"+host+":"+port+contextPath;
                 resp.sendRedirect(basePath+"/public/index.html");
                 return;
             }
         }
         chain.doFilter(request,response);  //非敏感资源或敏感资源登录之后，继续调用后续配置的过滤器
    }

    //销毁
    @Override
    public void destroy() {

    }
}
