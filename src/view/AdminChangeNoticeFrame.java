package view;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdminChangeNoticeFrame implements KeyListener {
    private static String hostname;
    JTextField messagestr_1 = new JTextField();
    String s;
    String adress;

    JFrame frame = new JFrame("发布消息");
    AdminChangeNoticeFrame() throws UnknownHostException {
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel messagestr= new JLabel("内容为");
        messagestr.setBounds(30, 4, 50, 50);
        frame.add(messagestr);
        frame.setLocationRelativeTo(null);


        messagestr_1.setBounds(90, 20, 300, 21);
        frame.add(messagestr_1);
        frame.setVisible(true);

        messagestr_1.addKeyListener(this);
        InetAddress addr = InetAddress.getLocalHost();
        adress=addr.getHostAddress();
//        System.out.printf(adress);

    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=messagestr_1.getText();
//            System.out.printf(s);
//            System.out.printf(adress);
            //写入数据库notice=s，服务器地址serviceaddr=adress
            System.out.printf("写入成功");
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
