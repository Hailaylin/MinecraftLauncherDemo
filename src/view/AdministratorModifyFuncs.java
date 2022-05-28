package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorModifyFuncs implements ActionListener {
    JFrame frame = new JFrame("管理员功能");
    JButton adduser= new JButton("增加用户");
    JButton deluser= new JButton("删除用户");
    JButton reuser= new JButton("修改用户信息");
    JButton fouser= new JButton("查询用户");
    JButton exit= new JButton("返 回");
    AdministratorModifyFuncs(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 200, 190);


        adduser.setBounds(35, 10, 120, 20);
        frame.add(adduser);

        deluser.setBounds(35, 36, 120, 20);
        frame.add(deluser);

        reuser.setBounds(35, 62, 120, 20);
        frame.add(reuser);

        fouser.setBounds(35, 88, 120, 20);
        frame.add(fouser);

        exit.setBounds(35, 114, 120, 20);
        frame.add(exit);


        adduser.addActionListener(this);
        deluser.addActionListener(this);
        reuser.addActionListener(this);
        fouser.addActionListener(this);
        exit.addActionListener(this);

        frame.setLocationRelativeTo(null);//屏幕中央弹出窗口
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AdministratorModifyFuncs();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            frame.setVisible(false);
        }
        else if (e.getSource()==adduser)
        {
                new AdminAddUserFrame();//增加用户
        }
        else if (e.getSource()==deluser)
        {
                new AdminDelUserFrame();//删除用户
        }
        else  if(e.getSource()==reuser)
        {
                 new AdminChangeUserFrame();//修改用户信息
        }
        else if (e.getSource()==fouser)
        {
                new AdminSelectUserFrame();//查询用户
        }
    }
}
