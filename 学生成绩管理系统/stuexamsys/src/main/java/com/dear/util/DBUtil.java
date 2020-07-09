package com.dear.util;
//数据库连接的工具类
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static volatile DataSource dataSource;
    private static final String URL = "jdbc:mysql://localhost:3306/stu_exam";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private DBUtil() {
    }

    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setUser(USERNAME);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败", e);
        }
    }

    public static void close(Connection c, Statement s){
        close(c,s,null);
    }
    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if (r != null)
                r.close();
            if (s != null)
                s.close();
            if (c != null)
                c.close();
        }catch (SQLException e){
            throw new RuntimeException("释放数据库资源出错",e);
        }
    }
}
