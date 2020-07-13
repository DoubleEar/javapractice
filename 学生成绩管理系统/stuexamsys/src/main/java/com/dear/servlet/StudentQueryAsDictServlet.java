package com.dear.servlet;
//查询学生（数据字典）的servlet处理
import com.dear.dao.StudentDAO;
import com.dear.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取班级id，通过班级id查找对应的学生。
        String id=req.getParameter("dictionaryKey");
        List<DictionaryTag> tags=StudentDAO.queryAsDict(Integer.parseInt(id));
        return tags;
    }
}
