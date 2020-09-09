package com.dear.dao;
//对成绩的新增，删除，更新的更能进行了单元测试
import com.dear.model.ExamRecord;
import com.dear.model.Page;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ExamRecordDAOTest {
    @Test
    public void insert() {
        ExamRecordDAO examRecordDAO=new ExamRecordDAO();
        ExamRecord er=new ExamRecord();
        er.setExamId(1);
        er.setStudentId(2);
        er.setScore(new BigDecimal(99.8));
        examRecordDAO.insert(er);
    }

    @Test
    public void update() {
        ExamRecordDAO examRecordDAO=new ExamRecordDAO();
        ExamRecord er=new ExamRecord();
        er.setExamId(1);
        er.setStudentId(2);
        er.setScore(new BigDecimal(52.9));
        er.setId(27);
        examRecordDAO.update(er);
    }

    @Test
    public void delete() {
        ExamRecordDAO examRecordDAO=new ExamRecordDAO();
        String[] sid={"27"};
        examRecordDAO.delete(sid);
    }
}