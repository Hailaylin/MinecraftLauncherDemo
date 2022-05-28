package view;

import until.DBUtil;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class newmassage extends JFrame {


            // 定义组件
            private JScrollPane scpDemo;
            private JTableHeader jth;
            private JTable tabDemo;
            private JButton btnShow;
            // 构造方法
            newmassage(){
// 窗体的相关属性的定义
                super("新消息");
                this.setSize(330,400);
                this.setLayout(null);
                this.setLocation(100,50);
// 创建组件
                this.setLocationRelativeTo(null);
                this.scpDemo = new JScrollPane();
                this.scpDemo.setBounds(10,50,300,270);
                this.btnShow = new JButton("显示消息");
                this.btnShow.setBounds(10,10,300,30);
// 给按钮注册监听
                this.btnShow.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        btnShow_ActionPerformed(ae);
                    }
                });
// 将组件加入到窗体中
                add(this.scpDemo);
                add(this.btnShow);
// 显示窗体
                this.setVisible(true);
            }
            // 点击按钮时的事件处理
            public void btnShow_ActionPerformed(ActionEvent ae){
// 以下是连接数据源和显示数据的具体处理方法，请注意下
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
                        info[count][0] = rs.getString("server_id");
                        info[count][1] = rs.getString("notice");
                        info[count][2] = rs.getString("serverAddr");
                        count++;
                    }
// 定义表头
                    String[] title = {"id","notice","serverAddr"};
// 创建JTable
                    this.tabDemo = new JTable(info,title);
// 显示表头
                    this.jth = this.tabDemo.getTableHeader();
// 将JTable加入到带滚动条的面板中
                    this.scpDemo.getViewport().add(tabDemo);
                }catch(ClassNotFoundException cnfe){
                    JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
                }catch(SQLException sqle){
                    JOptionPane.showMessageDialog(null,"数据操作错误","错误", JOptionPane.ERROR_MESSAGE);
                }
            }

        }



