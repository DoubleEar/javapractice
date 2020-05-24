package com;

import tomcat.WebDescriptor;

public class WebXML extends WebDescriptor {
    public WebXML(){
        urlToName.put("/hello","HelloServlet");
        nameToClass.put("HelloServlet",
                "com.HelloServlet");
    }
}
