package com.dear.servlet;
//查询学生考试成绩的servlet处理
import com.dear.dao.ExamRecordDAO;
import com.dear.model.ExamRecord;
import com.dear.model.Page;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/examRecord/query")
public class ExamRecordQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Page page=Page.parse(req);
        List<ExamRecord> records=ExamRecordDAO.query(page);
        return records;
    }
}
