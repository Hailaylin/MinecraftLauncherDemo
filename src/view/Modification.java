package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modification implements ActionListener {
    JTextField newemail_1 = new JTextField();
    JTextField oldpsword_1 = new JTextField();
    JTextField newpasword_1 = new JTextField();
    JButton buttonregister_1 = new JButton("修改邮箱");
    JButton buttonregister_2 = new JButton("修改密码");
    JButton buttonregister_3 = new JButton("退出");

    private static String s;
    JFrame frame = new JFrame("修改信息");
    Modification(){



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

            newemail_1.setBounds(120, 20, 150, 21);
            frame.add(newemail_1);

            oldpsword_1.setBounds(120, 46, 150, 21);
            frame.add(oldpsword_1);

            newpasword_1.setBounds(120, 72, 150, 21);
            frame.add(newpasword_1);

            buttonregister_1.setBounds(280, 20, 100, 20);
            frame.add(buttonregister_1);
            buttonregister_2.setBounds(280, 72, 100, 20);
            frame.add(buttonregister_2);
            buttonregister_3.setBounds(280, 98, 100, 20);
            frame.add(buttonregister_3);
            buttonregister_1.addActionListener(this);
            buttonregister_2.addActionListener(this);
            buttonregister_3.addActionListener(this);


            frame.setLocationRelativeTo(null);//屏幕中央弹出窗口
            frame.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonregister_1)//修改电子邮箱
        {

        }
        else if(e.getSource()==buttonregister_2)//修改密码 要判断输入的旧密码与数据库中密码一直再进行新密码的写入
        {

        }
        else if (e.getSource()==buttonregister_3)
        {
            frame.dispose();
        }

    }
}
