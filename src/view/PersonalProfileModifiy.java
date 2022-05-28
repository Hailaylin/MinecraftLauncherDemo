package view;

import model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalProfileModifiy implements ActionListener {
    JTextField newEmailJT = new JTextField();
    JTextField oldPwdJT = new JTextField();
    JTextField newPwdJT = new JTextField();
    JButton changeEmailButton = new JButton("修改邮箱");
    JButton changePwdButton = new JButton("修改密码");
    JButton backButton = new JButton("返回");

    UserModel user;

    private static String s;
    JFrame frame = new JFrame("修改个人信息");

    PersonalProfileModifiy(UserModel userModel){
        user = userModel;

        frame.setLayout(null);
        frame.setBounds(160, 200, 400, 170);

        JLabel newemail= new JLabel("新电子邮箱");
        newemail.setBounds(30, 4, 100, 50);
        frame.add(newemail);
        JLabel oldpsword= new JLabel("旧密码");
        oldpsword.setBounds(45, 30, 100, 50);
        frame.add(oldpsword);
        JLabel newepsword= new JLabel("新密码");
        newepsword.setBounds(45, 56, 100, 50);
        frame.add(newepsword);

        // 文本框
        newEmailJT.setBounds(120, 20, 150, 21);
        frame.add(newEmailJT);

        oldPwdJT.setBounds(120, 46, 150, 21);
        frame.add(oldPwdJT);

        newPwdJT.setBounds(120, 72, 150, 21);
        frame.add(newPwdJT);

        changeEmailButton.setBounds(280, 20, 100, 20);
        frame.add(changeEmailButton);
        changePwdButton.setBounds(280, 72, 100, 20);
        frame.add(changePwdButton);
        backButton.setBounds(280, 98, 100, 20);
        frame.add(backButton);
        changeEmailButton.addActionListener(this);
        changePwdButton.addActionListener(this);
        backButton.addActionListener(this);

        frame.setLocationRelativeTo(null);//屏幕中央弹出窗口
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== changeEmailButton)//修改电子邮箱
        {

        }
        else if(e.getSource()== changePwdButton)//修改密码 要判断输入的旧密码与数据库中密码一直再进行新密码的写入
        {

        }
        else if (e.getSource()== backButton)
        {
            frame.dispose();
        }

    }
}
