package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AdminSelectUserFrame implements  ActionListener {
    JTextField selectuse_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("查询用户");
    JButton chick = new JButton("确定");
    AdminSelectUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("查询用户");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);

        chick.setBounds(350,20,68,21);
        frame.add(chick);
        frame.setLocationRelativeTo(null);

        selectuse_1.setBounds(90, 20, 250, 21);
        frame.add(selectuse_1);


        frame.setVisible(true);
        chick.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==chick)
        {
            s=selectuse_1.getText();//s为输入框文本内容
            System.out.printf(s);
            //TODO 查询数据库用户 s为文本框内容即要查询的用户名

            frame.setVisible(false);
            JOptionPane.showMessageDialog(null,"用户查询","查询成功",JOptionPane.NO_OPTION);
        }
    }
}
