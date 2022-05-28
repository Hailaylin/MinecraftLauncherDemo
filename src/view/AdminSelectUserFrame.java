package view;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AdminSelectUserFrame implements KeyListener {
    JTextField selectuse_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("查询用户");
    AdminSelectUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("查询用户");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);


        selectuse_1.setBounds(90, 20, 300, 21);
        frame.add(selectuse_1);


        frame.setVisible(true);
        selectuse_1.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=selectuse_1.getText();
            System.out.printf(s);

            System.out.printf("用户查询成功");//此处应该调用sql进行查询角色
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
