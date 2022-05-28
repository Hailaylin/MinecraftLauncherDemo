package view;

import model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileFrame implements ActionListener {

    JButton modifyBotton = new JButton("修改");
    JButton backBotton = new JButton("返回");
    JFrame frame = new JFrame("个人信息");
    UserModel user;

    ProfileFrame(UserModel user){
        this.user=user;
        frame.setLayout(null);
        JLabel nameStr = new JLabel("用户名");
        nameStr.setBounds(60, 50, 60, 15);
        frame.add(nameStr);

        JLabel mail = new JLabel("电子邮箱");
        mail.setBounds(45, 80, 60, 15);
        frame.add(mail);

        JLabel passwordStr = new JLabel("密 码");
        passwordStr.setBounds(60, 110, 60, 15);
        frame.add(passwordStr);

        JLabel powerStr = new JLabel("权 限");
        powerStr.setBounds(60, 140, 60, 15);
        frame.add(powerStr);

        JLabel userName = new JLabel(user.getUserName());
        userName.setBounds(100, 48, 120, 21);
        frame.add(userName);
        userName.setBorder(null);//去边框
        userName.setOpaque(false);//透明化

        JLabel useremail = new JLabel(user.getEmail());
        useremail.setBounds(100, 77, 120, 21);
        frame.add(useremail);
        useremail.setBorder(null);//去边框
        useremail.setOpaque(false);//透明化

        JPasswordField password = new JPasswordField(user.getUserPasswd());
        password.setEditable(false);
        password.setBounds(100, 108, 120, 21);
        frame.add(password);
        password.setBorder(null);//去边框
        password.setOpaque(false);//透明化

        JLabel powerstr = new JLabel(String.valueOf(user.getIdentity()));
        powerstr.setBounds(100, 138, 120, 21);
        frame.add(powerstr);
        powerstr.setBorder(null);//去边框
        powerstr.setOpaque(false);//透明化

        modifyBotton.setBounds(30, 190, 60, 23);
        frame.add(modifyBotton);

        backBotton.setBounds(130, 190, 60, 23);
        frame.add(backBotton);
        frame.setBounds(100, 100, 250, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        modifyBotton.addActionListener(this);
        backBotton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== modifyBotton){
            frame.dispose();
            new Modification(user);//个人信息修改界面
        }
        else if (e.getSource()== backBotton){
            frame.setVisible(false);
        }
    }


}
