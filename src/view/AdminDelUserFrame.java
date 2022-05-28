package view;

import dao.UpdateDao;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class AdminDelUserFrame implements KeyListener {
    JTextField deletuser_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("游戏路径");
    AdminDelUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("删除用户");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);


        deletuser_1.setBounds(90, 20, 300, 21);
        frame.add(deletuser_1);


        frame.setVisible(true);
        deletuser_1.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //就只做了删除操作，查重时的报错没解决
    //目前只能做删除，不能查看用户存不存在
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=deletuser_1.getText();
            System.out.printf(s);
            UpdateDao de=new UpdateDao();
            try {
                de.delete_name(s);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "玩家不存在！","删除失败",JOptionPane.ERROR_MESSAGE);
            }
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
