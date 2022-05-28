package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.RegisterDao;
import model.UserModel;

public class RegisterFrame extends JFrame {
    RegisterFrame() {
        JFrame frame = new JFrame("注册账号");
        frame.setLayout(null);
        JLabel nameStr = new JLabel("用户名");
        nameStr.setBounds(60, 50, 60, 15);
        frame.add(nameStr);

        JLabel mail = new JLabel("电子邮箱");
        mail.setBounds(45, 80, 60, 15);
        frame.add(mail);

        JLabel passwordStr = new JLabel("密 码");
        passwordStr.setBounds(60, 110, 60, 15);
        frame.add(passwordStr);

        JLabel confrimStr = new JLabel("确认密码");
        confrimStr.setBounds(45, 140, 60, 15);
        frame.add(confrimStr);

        JTextField userName = new JTextField();
        userName.setBounds(100, 50, 120, 21);
        frame.add(userName);

        JTextField useremail = new JTextField();
        useremail.setBounds(100, 80, 120, 21);
        frame.add(useremail);

        JPasswordField password = new JPasswordField();
        password.setBounds(100, 110, 120, 21);
        frame.add(password);

        JPasswordField confrimPassword = new JPasswordField();
        confrimPassword.setBounds(100, 140, 120, 21);
        frame.add(confrimPassword);

        JButton confirmBotton = new JButton("确定");
        confirmBotton.setBounds(30, 190, 60, 23);
        frame.add(confirmBotton);
        JButton buttonregister_2 = new JButton("重置");
        buttonregister_2.setBounds(190, 190, 60, 23);
        frame.add(buttonregister_2);
        JButton buttonregister_3 = new JButton("返回");
        buttonregister_3.setBounds(110, 190, 60, 23);
        frame.add(buttonregister_3);

        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //为注册按钮增加监听器
        // 确认按钮
        confirmBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userName.getText();
                String passwd = new String(password.getPassword());
                String confrimpasswd = new String(confrimPassword.getPassword());
                String email = useremail.getText();

                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "用户名不能为空！", "用户名", JOptionPane.ERROR_MESSAGE);
                }
                else if(passwd.equals("")){
                    JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
                }
                else if(confrimpasswd.equals("")){
                    JOptionPane.showMessageDialog(null, "确认密码不能为空！", "确认密码为空", JOptionPane.ERROR_MESSAGE);
                }
                else if(passwd.equals(confrimpasswd)){      // 判断成功
                    UserModel regUser = new UserModel();
                    regUser.setUserName(name);
                    regUser.setUserPasswd(passwd);
                    regUser.setEmail(email);
                    regUser.setIdentity(1); // 默认权限1
                    RegisterDao registerDao = new RegisterDao(regUser);//这里要判断重名
                    registerDao.addUser();//添加用户信息
                    frame.dispose();
                    new LoginFrame().setVisible(true);
                    // 最后弹出注册成功
                    JOptionPane.showMessageDialog(null, "注册成功","注册成功",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "两次输入的密码不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        buttonregister_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password.setText("");
                userName.setText("");
                confrimPassword.setText("");
                useremail.setText("");
            }
        });
        buttonregister_3.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
            frame.dispose();
            new LoginFrame().setVisible(true);
        }
        });
    }

    // test frame
    public static void main(String[] args) {
        new RegisterFrame();
    }

}
