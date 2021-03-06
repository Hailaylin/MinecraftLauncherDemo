package view;

import model.UserModel;
import until.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdministratorFrame implements ActionListener {
//管理员
    UserModel user;
    final JButton exitBotton = new JButton("退出");
    JButton starGameBotton = new JButton("游戏启动");
    JButton profileBotton = new JButton("个人资料");
    JButton adminFuncBotton = new JButton("管理员功能");

    JButton addMsgBotton = new JButton("修改消息");
    JScrollPane scpDemo= new JScrollPane();
    // 窗体结构
    AdministratorFrame(UserModel user) {
        this.user=user;
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("管理员窗口");
        JLabel userStr = new JLabel("用户名:");
        userStr.setBounds(60, 30, 100, 50);
        frame.add(userStr);
        userStr.setFont(new Font("宋体", Font.PLAIN,16));
        JLabel userstr= new JLabel();
        userstr.setBounds(120, 30, 100, 50);
        userstr.setFont(new Font("宋体", Font.PLAIN,16));

        profileBotton.setBounds(60, 80, 100, 30);
        frame.add(profileBotton);
        profileBotton.setBorderPainted(false);//去边框

        adminFuncBotton.setBounds(60, 120, 100, 30);
        frame.add(adminFuncBotton);

        adminFuncBotton.setBorderPainted(false);

        addMsgBotton.setBounds(60, 160, 100, 30);
        frame.add(addMsgBotton);
        addMsgBotton.setBorderPainted(false);//去边框

        starGameBotton.setBounds(300, 60, 100, 60);
        starGameBotton.setFont(new Font(null, 0,16));
        frame.add(starGameBotton);
        starGameBotton.setBorderPainted(false);//去边框


        exitBotton.setBounds(300, 150, 100, 60);
        exitBotton.setFont(new Font(null, 0,16));
        frame.add(exitBotton);
        exitBotton.setBorderPainted(false);//去边框


        frame.setBounds(160, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        starGameBotton.addActionListener(this);
        exitBotton.addActionListener(this);
        profileBotton.addActionListener(this);
        adminFuncBotton.addActionListener(this);
//        showMsgBotton.addActionListener(this);
        addMsgBotton.addActionListener(this);

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
        if (e.getSource() == exitBotton) {
            System.exit(0);
        }

        else if (e.getSource()== starGameBotton)
        {
            JOptionPane.showMessageDialog(null,"启动成功","启动成功",JOptionPane.NO_OPTION);
         }

        else if(e.getSource()== profileBotton)
        {
            new ProfileFrame(user);//个人资料界面
            //已修改好
         }
        else if(e.getSource()== adminFuncBotton)
         {
             new AdministratorModifyFuncs();//管理员功能界面

         }

        else if(e.getSource()== addMsgBotton)
         {
             try {
                 new AdminChangeNoticeFrame();//发布消息界面
             } catch (UnknownHostException ex) {
                 throw new RuntimeException(ex);
             }
         }
    }

    // 测试窗体功能


}
