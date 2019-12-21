package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CommonUser extends JFrame implements ActionListener {
    private JPanel jp1, jp2, jp3,jp4;
    private JButton jb1, jb2,jb3,jb4;


    public CommonUser() {
        this.setTitle("用户操作");
        this.setSize(400, 550);
        this.setLocation(100, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));

        jp1 = new JPanel();
        jb1 = new JButton("存款");
        jp1.add(jb1);

        jp2 = new JPanel();
        jb2 = new JButton("取款");
        jp2.add(jb2);

        jp3 = new JPanel();
        jb3 = new JButton("查询余额");
        jp3.add(jb3);

        jp4 = new JPanel();
        jb4 = new JButton("退款");
        jp4.add(jb4);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
    }

    public static void main(String[] args) {
        new CommonUser();
    }

        @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()=="存款")
            {
                new SaveMoney(LogIn.input);
                this.setVisible(false);
            }

            if(e.getActionCommand()=="取款")
            {
                new GetMoney(LogIn.input);
                this.setVisible(false);
            }

            if(e.getActionCommand()=="查询余额")
            {
                new SelectMoney(LogIn.input);
                this.setVisible(false);
            }
            if(e.getActionCommand()=="退款")
            {
                new BackMoney(LogIn.input);
                this.setVisible(false);
            }
     }
}

