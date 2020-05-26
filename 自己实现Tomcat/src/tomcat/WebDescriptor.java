package tomcat;

import java.util.HashMap;
import java.util.Map;

public class WebDescriptor {
    //url-pattern对应servlet-name
    protected Map<String,String> urlToName=new HashMap<>();
    //servlet-name对应servlet-class
    protected Map<String,String> nameToClass=new HashMap<>();

    public String getServletNameByUrlPattern(String urlPattern){
        //TODO:web.xml中的url-pattern是支持正则表达式的
        //TODO:这里没有实现

        return urlToName.get(urlPattern);
    }

    public String getServletClassByServletName(String servletName){
        return nameToClass.get(servletName);
    }
}
