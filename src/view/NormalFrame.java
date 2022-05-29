package view;

import model.UserModel;
import until.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NormalFrame implements ActionListener {
    //普通用户
    UserModel user;
    JButton buttonregister_2 = new JButton("退出");
    JButton buttonregister_1 = new JButton("游戏启动");
    JButton psdoc = new JButton("个人资料");
    //    JButton newmesag = new JButton("新消息");
    JScrollPane scpDemo= new JScrollPane();
    NormalFrame(UserModel user)  {
        this.user=user;
        JFrame frame = new JFrame("普通用户窗体");
        frame.setLayout(null);
        JLabel userStr = new JLabel("用户名:");
        userStr.setBounds(60, 30, 100, 50);
        frame.add(userStr);

        userStr.setFont(new Font("宋体", Font.PLAIN,16));
        JLabel userstr= new JLabel(user.getUserName());//
        userstr.setBounds(120, 30, 100, 50);
        userstr.setFont(new Font(null, Font.PLAIN,16));

        psdoc.setBounds(60, 80, 100, 30);
        frame.add(psdoc);
        psdoc.setBorderPainted(false);//去边框


        buttonregister_1.setBounds(300, 60, 100, 60);
        buttonregister_1.setFont(new Font(null, 0,16));
        frame.add(buttonregister_1);
        buttonregister_1.setBorderPainted(false);//去边框

        buttonregister_2.setBounds(300, 150, 100, 60);
        buttonregister_2.setFont(new Font(null, 0,16));
        frame.add(buttonregister_2);
        buttonregister_2.setBorderPainted(false);//去边框


        frame.setBounds(160, 200, 450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        buttonregister_1.addActionListener(this);
        buttonregister_2.addActionListener(this);
        psdoc.addActionListener(this);
//        newmesag.addActionListener(this);

        JTable tabDemo = new JTable();
        scpDemo.setBounds(80, 0, 300, 37);
        frame.add(tabDemo);
        scpDemo.setOpaque(false);
        try{
// 获得连接
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DBUtil.getConn();// 这里用的我自己的DButil


// 建立查询条件
            String sql = "select * from servers";
            PreparedStatement pstm = conn.prepareStatement(sql);
// 执行查询
            ResultSet rs = pstm.executeQuery();
// 计算有多少条记录
            int count = 0;
            while(rs.next()){
                count++;
                System.out.println(count);
            }
            rs = pstm.executeQuery();
// 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][4];
            count = 0;
            while(rs.next()){
                info[count][0] = rs.getString("notice");
                info[count][1] = rs.getString("serverAddr");
                count++;
            }
// 定义表头
            String[] title = {"公告","服务器地址"};
            tabDemo = new JTable(info,title);
            tabDemo.getTableHeader();

            frame.add(scpDemo);
            scpDemo.getViewport().add(tabDemo);


        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"数据操作错误","错误", JOptionPane.ERROR_MESSAGE);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonregister_2)
        {
//            dispose();
            System.exit(0);

        }


        else if (e.getSource()==buttonregister_1)
        {
            JOptionPane.showMessageDialog(null,"游戏启动成功","游戏启动成功",JOptionPane.NO_OPTION);
        }

        else if(e.getSource()==psdoc)
        {
            new ProfileFrame(user);
            //todo 注意此处修改
        }

    }


}
