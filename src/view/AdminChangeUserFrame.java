package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminChangeUserFrame implements ActionListener {
    JTextField changename_1 = new JTextField();
    JTextField changepassword_1 = new JTextField();
    JTextField changepower_1 = new JTextField();
    JTextField changeemail_1 = new JTextField();
    JButton tj=new JButton("提交");
    private static String s0;
    private static String s1;
    private static String s2;
    private static String s3;
    JFrame frame = new JFrame("修改用户信息");
    AdminChangeUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 300, 250);

        JLabel changename= new JLabel("修改用户名");
        changename.setBounds(30, 4, 75, 50);
        frame.add(changename);
        frame.setLocationRelativeTo(null);
        changename_1.setBounds(100, 20, 170, 21);
        frame.add(changename_1);

        JLabel changepassword= new JLabel("修改 密码");
        changepassword.setBounds(30, 35, 75, 50);
        frame.add(changepassword);
        frame.setLocationRelativeTo(null);
        changepassword_1.setBounds(100, 50, 170, 21);
        frame.add(changepassword_1);

        JLabel changepower= new JLabel("修改 权限");
        changepower.setBounds(30, 66, 75, 50);
        frame.add(changepower);
        frame.setLocationRelativeTo(null);
        changepower_1.setBounds(100, 80, 170, 21);
        frame.add(changepower_1);

        JLabel changeemail= new JLabel("修改 邮箱");
        changeemail.setBounds(30, 97, 75, 50);
        frame.add(changeemail);
        frame.setLocationRelativeTo(null);
        changeemail_1.setBounds(100, 110, 170, 21);
        frame.add(changeemail_1);

        tj.setBounds(100, 150, 100, 40);
        frame.add(tj);
        tj.setBorderPainted(false);//去边框

        frame.setVisible(true);

        tj.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==tj){
            s0=changename_1.getText();
            s1=changepassword_1.getText();
            s2=changepower_1.getText();
            s3=changeemail_1.getText();
            //s0-s1分别为用户名，密码，权限，邮件 下面应sql加入数据库
            System.out.println("修改成功");

        }
    }
}
