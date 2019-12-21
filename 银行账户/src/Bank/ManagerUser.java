package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManagerUser extends JFrame implements ActionListener {
    private JPanel jp1, jp2, jp3,jp4;
    private JButton jb1, jb2,jb3,jb4;


    public ManagerUser() {
        this.setTitle("管理员操作");
        this.setSize(400, 350);
        this.setLocation(100, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        jp1 = new JPanel();
        jb1 = new JButton("开户");
        jp1.add(jb1);

        jp2 = new JPanel();
        jb2 = new JButton("销户");
        jp2.add(jb2);

        jp3 = new JPanel();
        jb3 = new JButton("查询账户");
        jp3.add(jb3);


        this.add(jp1);
        this.add(jp2);
        this.add(jp3);


        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }

    public static void main(String[] args) {
        new ManagerUser();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="开户")
        {
            new OpenAccount();
            this.setVisible(false);
        }
        if(e.getActionCommand()=="销户")
        {
            new ClearAccount();
            this.setVisible(false);
        }
        if(e.getActionCommand()=="查询账户")
        {
            new SelectAccount();
            this.setVisible(false);
        }
    }

}
