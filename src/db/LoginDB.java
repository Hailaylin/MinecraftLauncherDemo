package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ServerModel;
import model.UserModel;

public class LoginDB {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="mcldb";
    private static String password="mcldbpwd";
    private java.sql.Connection con;
    private PreparedStatement sta;

    // 初始化数据库驱动与连接
    public LoginDB(){
        //加载数据库驱动:
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
        }

        //连接数据库
        try {
            con= DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
        } catch (SQLException e) {
            System.out.println("连接失败");
        }

    }

    /**
     * @description: <p>用户名和密码登录，匹配成功则更新latestLoginTime为当前时间</p>
     * <p>更新loginTimes登录次数+1</p>
     *
     * @param name: 用户名
     * @return [java.lang.String, java.lang.String]
     *      返回1 为普通用户
     *      返回2 为管理员     //TODO:可能返回一个权限类型会好很多
     *      返回-1密码错误
     *      返回0 用户不存在
     * @author: enzeng, 星林 StarLin
     * @date: 2022/5/28 10:09
     */
    public UserModel getUserDB(String name) throws SQLException {
        String sql_select="select * from user where userName =?";
        sta= con.prepareStatement(sql_select);
        sta.setString(1,name);
        ResultSet rs= sta.executeQuery();
        rs.next();
        // 返回一个user对象，包含所有数据
        UserModel user = new UserModel(

            rs.getString(2),
            rs.getString(4),
            rs.getInt(7),
            rs.getString(3)
        );
        sta.close();
        con.close();
        return user;
    }

    /**
     * 获取数据库中最新的公告信息返回数据封装在Server Model中
     *
     * */
    public ServerModel  getSever() throws SQLException {
        String sql_count="select count(*) from user ";
        sta=con.prepareStatement(sql_count);
        ResultSet show1=sta.executeQuery();
        show1.next();
        int  sum=show1.getInt(1);//获取编号最新的notice

        String sql="select * from user where server_id =?";
        sta= con.prepareStatement(sql);
        sta.setInt(1,sum);
        ResultSet rs= sta.executeQuery();
        rs.next();
        // 返回一个server对象，包含所有公告数据
        ServerModel server = new ServerModel(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)

        );
        sta.close();
        con.close();
        return server;
    }

}
