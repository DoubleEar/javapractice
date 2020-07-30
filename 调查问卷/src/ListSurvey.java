import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//查询所有发布的问卷信息
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/API/list-surveys.json")
public class ListSurvey extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从数据库读取数据
        //2.把数据模型转化为JSON格式
        //3.最终效果使用标准API的形式返回
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/survey?characterEncoding=utf-8&&useSSL=false");
        mysqlDataSource.setUser("root");
        try(Connection c=mysqlDataSource.getConnection()){
            String sql="select\n" +
                    "  sid,\n" +
                    "  u.uid,\n" +
                    "  title,\n" +
                    "  brief,\n" +
                    "  nickname\n" +
                    "from survey s, users u\n" +
                    "where s.uid = u.uid and status = '已发布'\n" +
                    "order by sid desc";
            try(PreparedStatement s=c.prepareStatement(sql)){
                try(ResultSet rs=s.executeQuery()){
                    JSONArray array=new JSONArray();
                    while (rs.next()){
                        JSONObject object=new JSONObject();
                        object.put("sid",rs.getInt("sid"));
                        object.put("title",rs.getString("title"));
                        object.put("brief",rs.getString("brief"));
                        object.put("cover_url",rs.getString("cover_url"));
                        object.put("thanks",rs.getString("thanks"));

                        JSONObject user=new JSONObject();
                        user.put("uid",rs.getInt("uid"));
                        user.put("nickname",rs.getString("nickname"));
                        object.put("user",user);

                        array.add(object);
                    }

                    JSONObject result=new JSONObject();
                    result.put("status",200);
                    result.put("data",array);

                    resp.setContentType("application/json; charset=utf-8");
                    resp.getWriter().println(result.toJSONString());
                }
            }
        }catch (SQLException e){
            JSONObject object=new JSONObject();
            object.put("status",500);
            object.put("reason",e.getMessage());

            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().println(object.toJSONString());
        }
    }
}
