package api;

import com.alibaba.fastjson.JSON;
import model.Survey;
import service.SurveyService;
//将调查问卷列表数据转化为API格式的规定
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/API/list-surveys.json")
public class ListSurveysAPI extends AbsHttpServletAPI{
    private SurveyService surveyService;

    @Override
    public void init() throws ServletException {
        surveyService=new SurveyService();
    }

    @Override
    JSON getData(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Survey> surveyList=surveyService.list();

        return Survey.jsonUtil.toJSON(surveyList);
    }
}
