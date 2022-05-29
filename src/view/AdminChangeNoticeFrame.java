package view;

import dao.ServerDao;
import model.ServerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdminChangeNoticeFrame implements ActionListener {
    private static String hostname;
    JTextField messagestr_1 = new JTextField();
    String s;
    String adress;
    JButton chick = new JButton("确定");
    JFrame frame = new JFrame("修改消息");
    AdminChangeNoticeFrame() throws UnknownHostException {
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel messagestr= new JLabel("内容为");
        messagestr.setBounds(30, 4, 50, 50);
        frame.add(messagestr);
        frame.setLocationRelativeTo(null);

        chick.setBounds(350,20,68,21);
        frame.add(chick);
        frame.setLocationRelativeTo(null);

        messagestr_1.setBounds(90, 20, 250, 21);
        frame.add(messagestr_1);
        frame.setVisible(true);

        chick.addActionListener(this);
        InetAddress addr = InetAddress.getLocalHost();
        adress=addr.getHostAddress();
//        System.out.printf(adress);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==chick){
            s=messagestr_1.getText();
            ServerModel ser = new ServerModel(1,s,"starlin.world");
            ServerDao serverDao = new ServerDao();
            try{
                serverDao.setNotice(ser);
            }catch (Exception exception){
                exception.printStackTrace();
            }
            System.out.printf("写入成功");
//todo 写入数据库
            frame.setVisible(false);
            JOptionPane.showMessageDialog(null,"修改信息","修改成功",JOptionPane.NO_OPTION);
        }
    }
}
