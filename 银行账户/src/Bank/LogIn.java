package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener {
    JPanel jp1, jp2, jp3;
    JButton jb1, jb2;
    JLabel jl1, jl2;
    JTextField jtf;
    JPasswordField jpf;
    static String input;

    public LogIn() {
        this.setTitle("用户登录");
        this.setSize(500, 300);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        jp1 = new JPanel();
        jl1 = new JLabel("用户名");
        jtf = new JTextField(15);
        jp1.add(jl1);
        jp1.add(jtf);
        this.add(jp1);

        jp2 = new JPanel();
        jl2 = new JLabel("密码：");
        jpf = new JPasswordField(15);
        jp2.add(jl2);
        jp2.add(jpf);
        this.add(jp2);

        jp3 = new JPanel();
        jb1 = new JButton("登录");
        jb2 = new JButton("重置");
        jp3.add(jb1);
        jp3.add(jb2);
        this.add(jp3);

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }

    public static void main(String[] args) {

        new LogIn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        input = jtf.getText().trim();
        String result = jpf.getText().trim();

        if (e.getActionCommand() == "登录") {
            Statement stmt = null;
            ResultSet rs1 = null;
            Connection con = null;

            String driver = "com.hxtt.sql.access.AccessDriver";
            String dburl = "jdbc:Access:///E:/userlist.accdb";

            if (input.equals("") || result.equals("")) {
                JOptionPane.showMessageDialog(jtf, "密码或用户名不能为空");
            }
                if (input.equals("Admin") && result.equals("000000")) {
                    new ManagerUser();
                    this.setVisible(false);
                } else {
                    try {
                        Class.forName(driver);
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        con = DriverManager.getConnection(dburl, input, result);
                        stmt = con.createStatement();

                        rs1 = stmt.executeQuery("select * from User1 where uname = '" + input + "'");
                        if (rs1.next()) {
                            if (rs1.getString("pwd").equals(result)) {
                                new CommonUser();
                                this.setVisible(false);
                            }
                        } else {
                            JOptionPane.showMessageDialog(jtf, "登录名或密码错误");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                      }
                 }
            } else if (e.getActionCommand() == "重置") {
                jtf.setText("");
                jpf.setText("");
        }
    }
}












