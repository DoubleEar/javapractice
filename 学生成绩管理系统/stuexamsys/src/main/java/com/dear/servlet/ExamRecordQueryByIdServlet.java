package com.dear.servlet;
//查询学生考试成绩详情的servlet处理
import com.dear.dao.ExamRecordDAO;
import com.dear.model.ExamRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/examRecord/queryById")
public class ExamRecordQueryByIdServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取学生考试信息
        String id=req.getParameter("id");
        ExamRecord record=ExamRecordDAO.queryById(Integer.parseInt(id));
        return record;
    }
}
