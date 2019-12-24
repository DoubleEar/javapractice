package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectAccount extends JFrame implements ActionListener {
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1, jb2;
    JLabel jlb1,jlb2;
    JTextField jtf1,jtf2;
    JPasswordField jpf;

    //public SelectAccount() {}
    public SelectAccount() {

        jb1 = new JButton("确定");
        jb2 = new JButton("重置");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jlb1 = new JLabel("请输入要查询的账户名：");
        jlb2 = new JLabel("请输入要查询的账户密码：");

        //创建文本框
        jtf1 = new JTextField();
        jtf1 = new JTextField(15);
        jpf = new JPasswordField();
        jpf = new JPasswordField(15);
        jtf2 = new JTextField();
        jtf2 = new JTextField(22);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        //设置布局
        this.setTitle("查询账户");
        this.setLayout(null);
        this.setSize(300, 300);


        //确定确定和重置按钮
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);


        jp1.add(jlb1);
        jp1.add(jtf1);
        this.add(jp1);
        jp2.add(jlb2);
        jp2.add(jpf);
        this.add(jp2);
        jp3.add(jb1);
        jp3.add(jb2);
        this.add(jp3);
        jp4.add(jtf2);
        this.add(jp4);


        //在屏幕中间显示(居中显示)
        this.setLocationRelativeTo(null);
        //设置仅关闭当前窗口
        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void clear() {
        jtf1.setText("");
        jpf.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "确定") {
            selectAccount();
        } else if (e.getActionCommand() == "重置") {
            clear();
        }
    }

    private void selectAccount() {
        String input = jtf1.getText().trim();
        String result = jpf.getText().trim();

        Statement stmt = null;
        ResultSet rs1 = null;
        ResultSet rs2=null;
        Connection con = null;

        String driver = "com.hxtt.sql.access.AccessDriver";
        String dburl = "jdbc:Access:///E:/userlist.accdb";
        if (input.equals("") || result.equals("")) {
            JOptionPane.showMessageDialog(null, "用户名或密码不能为空" +
                    "请重新输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                con = DriverManager.getConnection(dburl);
                stmt = con.createStatement();
                rs1 = stmt.executeQuery("select * from User1 where uname = '" + input + "'");
                if (rs1.next()) {
                    if (rs1.getString("pwd").equals(result)) {
                        String u = rs1.getString("uname");
                        int p = rs1.getInt("pwd");
                        int b = rs1.getInt("balance");
                        jtf2.setText("用户名："+u+" "+"密码："+p+" "+"余额："+b);
                        jtf1.setText("");
                        jpf.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "没有该账户"
                            + "请重新输入:", "消息提示", JOptionPane.WARNING_MESSAGE);
                    clear();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

