package com.dear.dao;

import com.dear.model.*;
import com.dear.util.DBUtil;
//查询考试（数据字典）的数据库操作
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamDAO {
    public static List<Exam> queryAsDict() {
        List<Exam> exams=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            c= DBUtil.getConnection();
            String sql="select\n" +
                    "  e.id,\n" +
                    "  e.exam_name,\n" +
                    "  e.exam_desc,\n" +
                    "  e.course_id,\n" +
                    "  e.classes_id,\n" +
                    "  e.create_time,\n" +
                    "  c.classes_name,\n" +
                    "  c2.course_name\n" +
                    "from exam e\n" +
                    "join classes c on e.classes_id = c.id\n" +
                    "join course c2 on e.course_id = c2.id";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                //设置考试对象
                Exam e=new Exam();
                e.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                e.setDictionaryTagValue(rs.getString("exam_name"));
                e.setExamDesc(rs.getString("exam_desc"));
                e.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));


                //设置班级对象
                Classes classes=new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                e.setClasses(classes);

                //设置课程对象
                Course course=new Course();
                course.setId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                e.setCourse(course);


                exams.add(e);
            }
        }catch (Exception e){
            throw new RuntimeException("查询考试数据字典出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return exams;
    }
}
