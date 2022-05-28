package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class normaluser_data implements ActionListener {
    //普通用户
     JButton buttonregister_2 = new JButton("退出");
    JButton buttonregister_1 = new JButton("游戏启动");
    JButton psdoc = new JButton("个人资料");
    JButton newmesag = new JButton("新消息");
    normaluser_data()  {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        JLabel userStr = new JLabel("用户名:");
        userStr.setBounds(60, 30, 100, 50);
        frame.add(userStr);

        userStr.setFont(new Font("宋体", Font.PLAIN,16));
        JLabel userstr= new JLabel();//
        userstr.setBounds(120, 30, 100, 50);
        userstr.setFont(new Font(null, Font.PLAIN,16));

        psdoc.setBounds(60, 80, 100, 30);
        frame.add(psdoc);
        psdoc.setBorderPainted(false);//去边框

        newmesag.setBounds(60, 160, 100, 30);
        frame.add(newmesag);
        newmesag.setBorderPainted(false);


        buttonregister_1.setBounds(300, 60, 100, 60);
        buttonregister_1.setFont(new Font(null, 0,16));
        frame.add(buttonregister_1);
        buttonregister_1.setBorderPainted(false);//去边框

        buttonregister_2.setBounds(300, 150, 100, 60);
        buttonregister_2.setFont(new Font(null, 0,16));
        frame.add(buttonregister_2);
        buttonregister_2.setBorderPainted(false);//去边框


        frame.setBounds(160, 200, 450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonregister_1.addActionListener(this);
        buttonregister_2.addActionListener(this);
        psdoc.addActionListener(this);
        newmesag.addActionListener(this);
}



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonregister_2)
        {
//            dispose();
            System.exit(0);

        }


        else if (e.getSource()==buttonregister_1)
        {
            new Game_address();
        }

        else if(e.getSource()==psdoc)
        {
//            new ProfileFrame(user);   //TODO :这个窗口是否必要？
        }
        else if(e.getSource()==newmesag)
        {
            new newmassage();
        }
    }
}
