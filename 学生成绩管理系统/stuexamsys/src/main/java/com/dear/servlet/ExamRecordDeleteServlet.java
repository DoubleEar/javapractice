package com.dear.servlet;
//删除学生考试成绩的servlet处理
import com.dear.dao.ExamRecordDAO;
import com.dear.model.ExamRecord;
import com.dear.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/delete")
public class ExamRecordDeleteServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //从http请求中，反序列化为ExamRecord对象。
        String[] ids = req.getParameterValues("ids");
        int result=ExamRecordDAO.delete(ids);
        return null;
    }
}
