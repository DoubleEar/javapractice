package com.dear.servlet;
//查询学生考试成绩的servlet处理
import com.dear.dao.ExamRecordDAO;
import com.dear.model.ExamRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/examRecord/query")
public class ExamRecordQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<ExamRecord> records=ExamRecordDAO.query();
        return records;
    }
}
