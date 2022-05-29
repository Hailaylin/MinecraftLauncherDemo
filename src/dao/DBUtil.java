package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://handan.hailay.site:3306/player_management"; //TODO : 昨晚把电脑关了…… 远程数据库无了
    //user名为指定的数据库
    private static String user="mcldb";
    private static String password="mcldbpwd";
    public java.sql.Connection con;
    public PreparedStatement sta;

    // 初始化数据库驱动与连接
    public DBUtil(){
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
}
