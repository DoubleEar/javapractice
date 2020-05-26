package tomcat;


import standard.HttpServletRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpServletRequestImpl implements HttpServletRequest {
    private String method;
    private String path;
    Map<String,String> parameters=new HashMap<>();
    Map<String,String> headers=new HashMap<>();


    // 按照
    // 请求行
    // 请求头
    // 请求体
    // 的格式，解析发来的数据
    // 并封装成一个 HttpServletRequest 对象
    public static HttpServletRequest parse(InputStream is) throws UnsupportedEncodingException {
        HttpServletRequestImpl req=new HttpServletRequestImpl();

        // 因为 HTTP 协议是文本协议，直接读取 InputStream 不太方便
        // 所以，封装成一个 Scanner 对象进行读取，代码比较方便
        Scanner sc=new Scanner(is,"utf-8");

        // 1. 解析请求行
        parseRequestLine(sc,req);

        // 2. 解析请求头
        parseRequestHeaders(sc,req);

        //3. 解析请求体 —— TODO：为了简单的目的，我们不实现解析请求体的部分
        //parseRequestBody();

        System.out.println(req.method);
        System.out.println(req.path);
        System.out.println(req.parameters);
        System.out.println(req.headers);
        System.out.println("======================================");

        return req;
    }

    private static void parseRequestHeaders(Scanner sc, HttpServletRequestImpl req) {
        String line;
        while (!(line=sc.nextLine()).isEmpty()){
            String[] group=line.split(":");
            String key=group[0].trim();
            String value=group[1].trim();

            req.headers.put(key,value);
        }
    }

    private static void parseRequestLine(Scanner sc, HttpServletRequestImpl req) throws UnsupportedEncodingException {
        //1. 从 socket 中读取一行
        String line=sc.nextLine();
        // 2. 按照
        // <请求方法> <URL> <HTTP版本>的格式，进行解析工作
        String[] group=line.split(" ");
        // group[0] 方法
        // group[1] URL
        // group[2] HTTP 版本
        req.method=group[0].toUpperCase();
        parseUrl(req,group[1]);
    }

    private static void parseUrl(HttpServletRequestImpl req, String s) throws UnsupportedEncodingException {
        String[] group=s.split("\\?");
        req.path=group[0];
        if(group.length==1)
            return;

        String[] split=group[1].split("&");
        for(String kv:split){
            String[] kvs=kv.split("=");
            String name=URLDecoder.decode(kvs[0],"utf-8");
            String value=URLDecoder.decode(kvs[1],"utf-8");
            req.parameters.put(name,value);
        }
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }
}
