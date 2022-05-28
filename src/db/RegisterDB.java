package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;

//注册用户：支持创建管理员用户，普通用户，默认用户
public class RegisterDB {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="mcldb";
    private static String password="mcldbpwd";
    private java.sql.Connection con;
    private PreparedStatement sta;
    public RegisterDB(){
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

    //创建普通用户
    //唯一用到的函数，包含三个函数了，其余删去
    public int insertUserDB(UserModel user) throws SQLException {
        try {
            String sql_insert="insert into user(userName,userPasswd,userEmail,identity) values(?,?,?,?)";
            sta= con.prepareStatement(sql_insert);
            sta.setString(1,user.getUserName());
            sta.setString(2, user.getUserPasswd());
            sta.setString(3, user.getEmail());
            sta.setInt(4,user.getIdentity());
            sta.executeUpdate();
            System.out.println("普通用户注册成功");
        } catch (SQLException e) {
            System.out.println("普通用户注册失败");
            throw new RuntimeException(e);
        }
        sta.close();
        con.close();
        return 1;
    }

}
