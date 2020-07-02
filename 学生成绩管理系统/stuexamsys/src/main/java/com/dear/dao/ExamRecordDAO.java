package com.dear.dao;

import com.dear.model.*;
import com.dear.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamRecordDAO {
    public static List<ExamRecord> query() {
        List<ExamRecord> records=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            c= DBUtil.getConnection();
            String sql="select\n" +
                    "  er.id,\n" +
                    "  er.score,\n" +
                    "  er.student_id,\n" +
                    "  er.exam_id,\n" +
                    "  er.exam_record_desc,\n" +
                    "  er.create_time,\n" +
                    "  e.id prefix_e_id,\n" +
                    "  e.exam_desc prefix_e_exam_desc,\n" +
                    "  e.exam_name prefix_e_exam_name,\n" +
                    "  c.id prefix_c_id,\n" +
                    "  c.classes_name prefix_c_classes_name,\n" +
                    "  c2.id prefix_c2_id,\n" +
                    "  c2.course_name prefix_c2_course_name,\n" +
                    "  s.id prefix_s_id,\n" +
                    "  s.student_name prefix_s_name,\n" +
                    "  s.student_no prefix_s_student_no,\n" +
                    "  s.id_card prefix_s_id_card,\n" +
                    "  s.student_email prefix_s_student_email\n" +
                    "from exam_record er join exam e on er.exam_id = e.id join classes c on e.classes_id = c.id\n" +
                    "join course c2 on e.course_id = c2.id join student s on c.id = s.classes_id";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                //设置考试成绩对象
                ExamRecord er=new ExamRecord();
                er.setId(rs.getInt("id"));
                er.setScore(rs.getBigDecimal("score"));
                er.setExamRecordDesc(rs.getString("exam_record_desc"));
                er.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));

                //设置考试对象
                Exam e=new Exam();
                e.setId(rs.getInt("prefix_e_id"));
                e.setExamName(rs.getString("prefix_e_exam_name"));
                e.setExamDesc(rs.getString("prefix_e_exam_desc"));
                er.setExam(e);

                //设置班级对象
                Classes classes=new Classes();
                classes.setId(rs.getInt("prefix_c_id"));
                classes.setClassesName(rs.getString("prefix_c_classes_name"));
                er.setClasses(classes);

                //设置课程对象
                Course course=new Course();
                course.setId(rs.getInt("prefix_c2_id"));
                course.setCourseName(rs.getString("prefix_c2_course_name"));
                er.setCourse(course);

                //设置学生对象
                Student student=new Student();
                student.setId(rs.getInt("prefix_s_id"));
                student.setStudentName(rs.getString("prefix_s_name"));
                student.setStudentNo(rs.getString("prefix_s_student_no"));
                student.setStudentEmail(rs.getString("prefix_s_student_email"));
                student.setIdCard(rs.getString("prefix_s_id_card"));
                er.setStudent(student);

                records.add(er);
            }
        }catch (Exception e){
            throw new RuntimeException("查询考试成绩列表出错",e);
        }
        return records;
    }
}
