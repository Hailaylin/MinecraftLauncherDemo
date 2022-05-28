package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class people_data implements ActionListener {
    //游客
    JButton buttonregister_2 = new JButton("退出");
    JButton buttonregister_1 = new JButton("游戏启动");
    JButton newmesag = new JButton("新消息");
    people_data() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        JLabel userStr = new JLabel("用户名:");
        userStr.setBounds(60, 30, 100, 50);
        userStr.setFont(new Font("宋体", Font.PLAIN,16));
        frame.add(userStr);

        JLabel userstr= new JLabel("游客");
        userstr.setBounds(120, 30, 100, 50);
        userstr.setFont(new Font("宋体", Font.PLAIN,16));
        frame.add(userstr);
        userstr.setBorder(null);//去边框
        userstr.setOpaque(false);//透明化


        newmesag.setBounds(60, 160, 100, 30);
        newmesag.setFont(new Font(null, Font.PLAIN,16));
        frame.add(newmesag);

        newmesag.setBorderPainted(false);

        buttonregister_1.setBounds(300, 60, 100, 60);
        buttonregister_1.setFont(new Font(null, Font.PLAIN,16));
        frame.add(buttonregister_1);
        buttonregister_1.setBorderPainted(false);//去边框


        buttonregister_2.setBounds(300, 150, 100, 60);
        buttonregister_2.setFont(new Font(null, 0,16));
        frame.add(buttonregister_2);
        buttonregister_2.setBorderPainted(false);//去边框


        frame.setBounds(160, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        buttonregister_1.addActionListener(this);
        buttonregister_2.addActionListener(this);
        newmesag.addActionListener(this);

    }
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

        else if(e.getSource()==newmesag)
        {
            new newmassage();
        }


    }


}

