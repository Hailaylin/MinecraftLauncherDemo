package view;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=adduser_1.getText();
            System.out.printf(s);

            System.out.printf("用户添加成功");//此处应该调用sql进行添加角色
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new AdminAddUserFrame();
    }
}
