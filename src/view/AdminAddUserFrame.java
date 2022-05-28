package view;

import dao.UpdateDao;
import model.UserModel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class AdminAddUserFrame implements KeyListener {
    JTextField adduser_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("添加用户");
    AdminAddUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("新用户为");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);


        adduser_1.setBounds(90, 20, 300, 21);
        frame.add(adduser_1);


        frame.setVisible(true);
        adduser_1.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override

    /**
     * 添加玩家：和已有用户重名时，报错
     * 不报错则添加成功
     * 创建的用户初始密码:000000,权限：普通用户
     * */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=adduser_1.getText();
            System.out.printf(s);

            try {
                UserModel user= new UserModel(s,"000000",1,null);
                UpdateDao up =new UpdateDao();
                up.insert(user);
                //JOptionPane.showMessageDialog(null, "玩家添加成功！","修改成功",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "玩家添加失败！(重名)","添加失败",JOptionPane.ERROR_MESSAGE);
            }
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
