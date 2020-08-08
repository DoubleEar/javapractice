package service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import model.Survey;
import model.User;
//问卷的逻辑处理
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//调查问卷列表展示
public class SurveyService {
    public List<Survey> list() throws SQLException {
        List<Survey> surveyList = new ArrayList<>();

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/survey?characterEncoding=utf-8&&useSSL=false");
        mysqlDataSource.setUser("root");
        try (Connection c = mysqlDataSource.getConnection()) {
            String sql = "select\n" +
                    "  sid,\n" +
                    "  u.uid,\n" +
                    "  title,\n" +
                    "  brief,\n" +
                    "  cover_url,\n" +
                    "  nickname\n" +
                    "from survey s, users u\n" +
                    "where s.uid = u.uid and status = '已发布'\n" +
                    "order by sid desc";
            try (PreparedStatement s = c.prepareStatement(sql)) {
                try (ResultSet rs = s.executeQuery()) {
                    while (rs.next()) {
                        Survey survey=new Survey();
                        survey.sid=rs.getInt("sid");
                        survey.title=rs.getString("title");
                        survey.brief=rs.getString("brief");
                        survey.coverUrl=rs.getString("cover_url");

                        User user=new User();
                        user.uid=rs.getInt("uid");
                        user.nickname=rs.getString("nickname");

                        survey.user=user;

                        surveyList.add(survey);
                    }
                }
            }
        }
        return surveyList;
    }
}
