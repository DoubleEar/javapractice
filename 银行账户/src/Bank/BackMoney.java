package Bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BackMoney extends JFrame implements ActionListener {

    String uname1;
    JButton jb1, jb2;
    JLabel jlb1;
    JTextArea jta1, jta2;

    //public BackMoney() {}
    public BackMoney(String input) {
        this.uname1 =input;

        jb1 = new JButton("确定");
        jb2 = new JButton("重置");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jlb1 = new JLabel("请输入退款金额：");

        //创建文本框
        jta1 = new JTextArea();
        jta2 = new JTextArea();


        //设置布局
        this.setTitle("退款");
        this.setLayout(null);
        this.setSize(300, 300);

        //存入标签和文本框
        jlb1.setBounds(5, 20, 200, 20);
        jta1.setBounds(20, 50, 250, 50);

        //确定和重置按钮
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);

        //显示结果文本框
        jta2.setBounds(20, 160, 300, 50);
        jta2.setFont(new java.awt.Font("Dialog", 1, 15));


        this.add(jlb1);
        this.add(jta1);
        this.add(jb1);
        this.add(jb2);
        this.add(jta2);

        //在屏幕中间显示(居中显示)
        this.setLocationRelativeTo(null);
        //设置仅关闭当前窗口
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    //清空
    private void clear() {
        jta1.setText("");
        jta2.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "重置") {
            clear();
        }else if(e.getActionCommand() == "确定")
        {
            if (jta1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "金额为空，" +
                        "请重新输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
            } else if (Integer.parseInt(jta1.getText()) > 0) {

                String input = jta1.getText().trim();
                String result = jta2.getText().trim();

                Statement stmt = null;
                ResultSet rs1 = null;
                int rs2 = 0;
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
                    rs1=stmt.executeQuery("select balance from User1 where uname = '"+uname1+"'");
                    if(rs1.next()) {
                        a = rs1.getInt("balance");
                    }
                    int Money1=a+Integer.parseInt(jta1.getText());
                    rs2 = stmt.executeUpdate("update User1 set balance="+Money1+" where uname = '"+uname1+"'");
                    jta2.setText("退款成功,您的余额为："+Money1);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "余额不足"
                        + "请重新输入:", "消息提示", JOptionPane.WARNING_MESSAGE);
                clear();
            }
        }
    }

    public static void main(String[] args) {
        new BackMoney("input");
    }
}
