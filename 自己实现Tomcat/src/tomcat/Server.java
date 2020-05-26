package tomcat;
import com.WebXML;
import standard.HttpServlet;
import standard.HttpServletRequest;
import standard.Servlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT=8080;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 0. 为了支持并发特性，使用线程池方式
        ExecutorService pool=Executors.newFixedThreadPool(8);

        initServlets();

        // 1. 进行 TCP 监听
        try(ServerSocket serverSocket=new ServerSocket(PORT)){
            // 2. 不断进行 accept，获取连接成功的连接
            while (true){
                Socket socket=serverSocket.accept();

                // 进行业务处理
                // 创建一个 HTTP 处理流程任务
                Task task=new Task(socket);
                pool.execute(task);
            }
        }
    }


    private static WebXML webXML;
    // 用来保存，用到的所有的 Servlet 对象
    //Key:ServletClass
    //Value:该Class对应的一个Servlet对象
    //com.HelloServlet->HelloServlet对象

    private static Map<String, Servlet> servlets=new HashMap<>();

    private static void initServlets() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 模拟扫描出所有的 web 应用下的 web.xml
        // 解析 web.xml 并且实例化这些 web.xml 中需要的 Servlet 对象
        webXML=new WebXML();
        Collection<String> servletClasses=webXML.nameToClass.values();

        //实例化这些 Servlet-Class
        //使用反射方式实例化
        for(String servletClass:servletClasses){
            //构建出该对象——使用反射机制
            Class<Server>clz= (Class<Server>) Class.forName(servletClass);
            Servlet servlet= (Servlet) clz.newInstance();

            servlet.init();     // 执行生命周期中 init 方法

            servlets.put(servletClass,servlet); // 放到 servlets 映射关系中
        }
    }

    private static void destoryServlets(){
        Collection<Servlet> values=servlets.values();
        for(Servlet servlet:values){
            servlet.destroy();
        }
    }

    private static StaticResourceServlet staticResourceServlet=new StaticResourceServlet();
    private static HttpServlet notFoundServlet=new NotFoundServlet();

    public static Servlet getServletFromWebXML(String path){
        String servletName=webXML.getServletNameByUrlPattern(path);
        if(servletName==null)
            return null;

        String servletClass=webXML.getServletClassByServletName(servletName);
        if(servletClass==null)
            return null;

        Servlet servlet=servlets.get(servletClass);

        return servlet;
    }

    static HttpServlet selectServlet(HttpServletRequest req){
        HttpServlet servlet=(HttpServlet)Server.getServletFromWebXML(req.getPath());
        if(servlet!=null)
            return servlet;

        //web.xml 中没有配置该 url 的信息
        // 1. 试试看是不是静态资源
        //根据 req.getPath()，去特定文件夹下看该文件是不是存在

        if(staticResourceServlet.isStaticResource(req.getPath())){
            return staticResourceServlet;
        }

        //2.404de Servlet去处理
        return  notFoundServlet;
    }
    
}
