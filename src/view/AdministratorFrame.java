package view;

import model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;


public class AdministratorFrame implements ActionListener {
//管理员
    UserModel user;
    final JButton exitBotton = new JButton("退出");
    JButton starGameBotton = new JButton("游戏启动");
    JButton profileBotton = new JButton("个人资料");
    JButton adminFuncBotton = new JButton("管理员功能");
    JButton showMsgBotton = new JButton("新消息");
    JButton addMsgBotton = new JButton("发布消息");

    // 窗体结构
    AdministratorFrame(UserModel user) {
        this.user=user;
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("管理员窗口");
        JLabel userStr = new JLabel("用户名:");
        userStr.setBounds(60, 30, 100, 50);
        frame.add(userStr);
        userStr.setFont(new Font("宋体", Font.PLAIN,16));
        JLabel userstr= new JLabel();
        userstr.setBounds(120, 30, 100, 50);
        userstr.setFont(new Font("宋体", Font.PLAIN,16));

        profileBotton.setBounds(60, 80, 100, 30);
        frame.add(profileBotton);
        profileBotton.setBorderPainted(false);//去边框

        adminFuncBotton.setBounds(60, 120, 100, 30);
        frame.add(adminFuncBotton);

        adminFuncBotton.setBorderPainted(false);

        showMsgBotton.setBounds(60, 160, 100, 30);
        frame.add(showMsgBotton);
        showMsgBotton.setBorderPainted(false);

        addMsgBotton.setBounds(60, 200, 100, 30);
        frame.add(addMsgBotton);
        addMsgBotton.setBorderPainted(false);//去边框

        starGameBotton.setBounds(300, 60, 100, 60);
        starGameBotton.setFont(new Font(null, 0,16));
        frame.add(starGameBotton);
        starGameBotton.setBorderPainted(false);//去边框


        exitBotton.setBounds(300, 150, 100, 60);
        exitBotton.setFont(new Font(null, 0,16));
        frame.add(exitBotton);
        exitBotton.setBorderPainted(false);//去边框


        frame.setBounds(160, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        starGameBotton.addActionListener(this);
        exitBotton.addActionListener(this);
        profileBotton.addActionListener(this);
        adminFuncBotton.addActionListener(this);
        showMsgBotton.addActionListener(this);
        addMsgBotton.addActionListener(this);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBotton) {
            System.exit(0);
        }

        else if (e.getSource()== starGameBotton)
        {
             new Game_address();
         }

        else if(e.getSource()== profileBotton)
        {
            new ProfileFrame(user);//个人资料界面
         }
        else if(e.getSource()== adminFuncBotton)
         {
             new AdministratorModifyFuncs();//管理员功能界面
         }
        else if(e.getSource()== showMsgBotton)
         {
             new newmassage();//新消息界面
         }
        else if(e.getSource()== addMsgBotton)
         {
             try {
                 new AdminChangeNoticeFrame();//发布消息界面
             } catch (UnknownHostException ex) {
                 throw new RuntimeException(ex);
             }
         }
    }

    // 测试窗体功能


}
