package view;

import db.updata;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class AdminDelUserFrame implements ActionListener {
    JTextField deletuser_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("删除用户");
    JButton chick = new JButton("确定");
    AdminDelUserFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("删除用户");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);

        chick.setBounds(350,20,68,21);
        frame.add(chick);
        frame.setLocationRelativeTo(null);

        deletuser_1.setBounds(90, 20, 250, 21);
        frame.add(deletuser_1);


        frame.setVisible(true);
        chick.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chick) {
            s = deletuser_1.getText();
            System.out.printf(s);
            updata de = new updata();
            try {
                de.delete_name(s);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);
            JOptionPane.showMessageDialog(null,"删除用户","删除成功",JOptionPane.NO_OPTION);
        }

    }


}