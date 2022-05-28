package view;

import db.RegisterDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class AdminAddUserFrame implements ActionListener {
    JTextField adduser_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("添加用户");
    JButton chick = new JButton("确定");
    AdminAddUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("新用户为");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);

        chick.setBounds(350,20,68,21);
        frame.add(chick);
        frame.setLocationRelativeTo(null);

        adduser_1.setBounds(90, 20, 250, 21);
        frame.add(adduser_1);


        frame.setVisible(true);
        chick.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s=adduser_1.getText();
        System.out.printf(s);
        RegisterDB Re = new RegisterDB();
        try {
            Re.insert_user_tourist(s);//初始密码000000
            frame.dispose();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        frame.setVisible(false);
        JOptionPane.showMessageDialog(null,"添加用户","添加成功",JOptionPane.NO_OPTION);
    }
}
