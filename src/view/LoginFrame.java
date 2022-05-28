package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import dao.LoginDao;
import model.UserModel;

public class LoginFrame extends JFrame implements ItemListener, ActionListener {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private UserModel user;                 // 保存用户信息，各窗体通用

    public static void main(String args[]) {
        new LoginFrame().setVisible(true);
        // 设置窗体可见，默认为不可见
        // 默认程序入口
    }

    final JRadioButton people = new JRadioButton("游客");
    final JRadioButton manager = new JRadioButton("管理员");
    final JRadioButton normaluser = new JRadioButton("普通用户");
    final JButton registerButton = new JButton();
    final JButton exitButton = new JButton();
    final JButton landButton = new JButton();
    int selectFrameType =0;//默认游客

    // 窗体绘画
    public LoginFrame() {
        super(); // 继承父类的构造方法
        setTitle("我的世界玩家管理系统");
        setBounds(100, 100, 300, 300); // 设置窗体的显示位置及大小 height = 窗体的高
        getContentPane().setLayout(null); // 设置为不采用任何布局管理器
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setBorder(new TitledBorder(null, "",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, null, null));
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("", Font.BOLD, 18));

        JLabel helloLabel = new JLabel("New label");
        helloLabel.setIcon(new ImageIcon("src/img/1.gif"));
        helloLabel.setBackground(Color.BLACK);
        helloLabel.setBounds(60, 20, 170, 80);
        getContentPane().add(helloLabel); //图片显示

        final JLabel usernameLabel = new JLabel();
        usernameLabel.setText("用户名");
        usernameLabel.setBounds(43, 110, 60, 15); // 设置“用户名”标签的显示位置及大小
        getContentPane().add(usernameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(94, 107, 120, 21); // 设置“用户名”文本框的显示位置及大小
        getContentPane().add(userNameField);

        final JLabel passwordLabel = new JLabel();
        passwordLabel.setText("密  码");
        passwordLabel.setBounds(43, 137, 60, 15); // 设置“密 码”标签的显示位置及大小
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(94, 134, 120, 21); // 设置“密 码”密码框的显示位置及大小
        getContentPane().add(passwordField);

//        JButton addButton = new JButton();
        registerButton.setText("注册");
        registerButton.setBounds(30, 210, 60, 23); // 设置“退出”按钮的显示位置及大小
        getContentPane().add(registerButton);


//        JButton exitButton = new JButton();
        exitButton.setText("退出");
        exitButton.setBounds(200, 210, 60, 23); // 设置“退出”按钮的显示位置及大小
        getContentPane().add(exitButton);

//        JButton landButton = new JButton();
        landButton.setText("登录");
        landButton.setBounds(115, 210, 60, 23); // 设置“登录”按钮的显示位置及大小
        getContentPane().add(landButton);

        ButtonGroup buttongroup = new ButtonGroup();
//        JRadioButton manager=new JRadioButton("管理员");
        manager.setBounds(30, 170, 70, 20);
        buttongroup.add(manager);
        getContentPane().add(manager);


//        JRadioButton normaluser=new JRadioButton("普通用户");
        normaluser.setBounds(110, 170, 75, 20);
        buttongroup.add(normaluser);
        getContentPane().add(normaluser);

        people.setBounds(200, 170, 75, 20);
        buttongroup.add(people);
        getContentPane().add(people);

        manager.addItemListener(this);
        normaluser.addItemListener(this);
        landButton.addActionListener(this);
        exitButton.addActionListener(this);
        registerButton.addActionListener(this);
        people.setSelected(true);
        people.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == manager) {
            selectFrameType = 2;
        } else if (e.getSource() == normaluser) {
            selectFrameType = 1;
        }
        else if (e.getSource() == people) {     // 游客
            selectFrameType = 0;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == landButton) {
            // 从数据库中获取数据并判断
            LoginDao loginDao = new LoginDao();
            int userIdentity =loginDao.judgeUserNamePwd(userNameField.getText(), new String(passwordField.getPassword()));
            if(userIdentity == -1){
                JOptionPane.showMessageDialog(null, "您输入的用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
            }


            if (selectFrameType == 2 && userIdentity == 2)//判断里加一个判断条件：数据库中是权限对应数值是否与indentity相等
            {
                new AdministratorFrame(loginDao.getUser());//管理员窗口
                setVisible(false);
                System.out.println("管理员窗口");
            }
            else if (selectFrameType == 1 && userIdentity >= 1)     // 权限继承，管理员身份可以进入任何窗体
            {
                new normaluser_data(loginDao.getUser());//普通用户窗口
                setVisible(false);
                System.out.println("普通用户窗口");
            }
            else if (selectFrameType == 0 && userIdentity >=0)
            {
                new people_data();//游客用户窗口
                setVisible(false);
                System.out.println("游客用户窗口");
            }
        }

        else if (e.getSource() == exitButton)
        {
            dispose();
            System.exit(0);//退出界面
        }

        else if (e.getSource() == registerButton)
        {
            this.dispose();
            RegisterFrame registerFrame = new RegisterFrame();//注册界面
        }
    }
}