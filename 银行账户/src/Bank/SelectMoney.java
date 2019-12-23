package Bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectMoney extends JFrame implements ActionListener {
    String uname1;
    JButton jb1, jb2;
    JLabel jlb1;
    JTextArea jta1;

    //public SelectMoney() {}
    public SelectMoney(String input) {
        this.uname1 =input;

        jb1 = new JButton("查询");
        jb2 = new JButton("取消");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jlb1 = new JLabel("你的余额为：");

        //创建文本框
        jta1 = new JTextArea();

        //设置布局
        this.setTitle("余额查询");
        this.setLayout(null);
        this.setSize(300, 200);

        //存入标签和文本框
        jlb1.setBounds(5, 20, 200, 20);
        jta1.setBounds(20, 50, 250, 50);


        //确定和取消按钮
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);


        this.add(jlb1);
        this.add(jta1);
        this.add(jb1);
        this.add(jb2);


        //在屏幕中间显示(居中显示)
        this.setLocationRelativeTo(null);
        //设置仅关闭当前窗口
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectMoney("input");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "取消") {
            this.setVisible(false);
        } else if (e.getActionCommand() == "查询") {
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        int a=0;

        String driver = "com.hxtt.sql.access.AccessDriver";
        String dburl = "jdbc:Access:///E:/userlist.accdb";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(dburl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select balance from User1 where uname = '"+uname1+"'");
            if(rs.next()) {
                a = rs.getInt("balance");
            }
             jta1.setText("您的余额为："+a);
         } catch (SQLException e1) {
            e1.printStackTrace();
        }
        }
    }
}
