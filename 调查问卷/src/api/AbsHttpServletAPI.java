package api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public abstract class AbsHttpServletAPI extends HttpServlet {
    abstract JSON getData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        try{
            JSON object=getData(req,resp);
            JSONObject success=new JSONObject();
            success.put("status",200);
            success.put("data",object);
            resp.getWriter().println(success.toJSONString());
        }catch (Exception e){
            JSONObject error=new JSONObject();
            error.put("status",500);
            error.put("reason",e.getMessage());
            resp.getWriter().println(error);
        }
    }
}
