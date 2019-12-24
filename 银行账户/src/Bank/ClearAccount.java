package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ClearAccount extends JFrame implements ActionListener {
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1, jb2;
    JLabel jlb1,jlb2;
    JTextField jtf1, jtf2,jtf3;

    //public ClearAccount() {}
    public ClearAccount() {

        jb1 = new JButton("删除");
        jb2 = new JButton("重置");
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);


        jlb1 = new JLabel("请输入要删除的账户名：");
        jlb2 = new JLabel("请输入要删除的账户密码：");

        //创建文本框
        jtf1 = new JTextField();
        jtf1 = new JTextField(15);
        jtf2 = new JTextField();
        jtf2 = new JTextField(15);
        jtf3 = new JTextField();
        jtf3 = new JTextField(15);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        //设置布局
        this.setTitle("删除账户");
        this.setLayout(null);
        this.setSize(300, 300);


        //确定删除和重置按钮
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);


        jp1.add(jlb1);
        jp1.add(jtf1);
        this.add(jp1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        this.add(jp2);
        jp3.add(jb1);
        jp3.add(jb2);
        this.add(jp3);
        jp4.add(jtf3);
        this.add(jp4);


        //在屏幕中间显示(居中显示)
        this.setLocationRelativeTo(null);
        //设置仅关闭当前窗口
        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    //清空
    private void clear() {
        jtf1.setText("");
        jtf2.setText("");
    }
        @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "删除") {
                clearAccount();
            } else if (e.getActionCommand() == "重置") {
                clear();
            }

        }

    private void clearAccount() {
        String input = jtf1.getText().trim();
        String result=jtf2.getText().trim();

        Statement stmt = null;
        ResultSet rs1=null;
        Connection con = null;

        String driver = "com.hxtt.sql.access.AccessDriver";
        String dburl = "jdbc:Access:///E:/userlist.accdb";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } try {
            con = DriverManager.getConnection(dburl);
            stmt = con.createStatement();
            rs1=stmt.executeQuery("select * from User1 where uname = '"+input+"'");
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "用户名为空，" +
                        "请重新输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
            }else if(rs1.next()) {
                if (rs1.getString("pwd").equals(result)) {
                    stmt.executeUpdate("delete from User1 where uname = '" + input + "'");
                    jtf3.setText("删除成功");
                }
            }else{
                JOptionPane.showMessageDialog(null, "没有此用户"
                        + "请重新输入:","消息提示",JOptionPane.WARNING_MESSAGE);
                clear();
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
         }

        }
    }


