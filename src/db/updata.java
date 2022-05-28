package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//数据库的连接关闭和简单的更新
class updata {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="mcldb";
    private static String password="mcldbpwd";
    private java.sql.Connection con;
    private PreparedStatement sta;
    public updata(){
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


    //更改密码
    public void update_password(String password,int ID) throws SQLException {
        String sql_update="update user set userPasswd= ?  where id=?";
        sta=con.prepareStatement(sql_update);
        sta.setString(1,password);
        sta.setInt(2,ID);
        sta.executeUpdate();
        System.out.println("更新密码成功");
        sta.close();
        con.close();
    }


    //更改用户名
    public void update_name(String name,int ID) throws SQLException {
        String sql_update="update user set userName=? where ID=?";
        sta=con.prepareStatement(sql_update);
        sta.setString(1,name);
        sta.setInt(2,ID);
        sta.executeUpdate();
        System.out.println("更新用户名成功");
        sta.close();
        con.close();
    }
    //更新邮箱
    public void update_email(String email,int ID) throws SQLException {
        String sql_update="update user set userEmail=? where id=?";
        sta=con.prepareStatement(sql_update);
        sta.setString(1,email);
        sta.setInt(2,ID);
        sta.executeUpdate();
        System.out.println("邮箱更新成功");
        sta.close();
        con.close();
    }
    //更新用户名用户、密码、邮箱
    public void update(String name,String password,String email,int ID) throws SQLException {
        String sql_update="update user set userName=?,userPasswd=? userEmail =? where id=?";
        sta=con.prepareStatement(sql_update);
        sta.setString(1,name);
        sta.setString(2,password);
        sta.setString(3,email);
        sta.setInt(4,ID);
        sta.executeUpdate();
        System.out.println("更新用户名、密码、邮箱成功");
        sta.close();
        con.close();
    }
    //变更为管理员权限
    public void update_admin(int ID) throws SQLException {
        String sql_update="update user set identity=2 where id=?";
        sta=con.prepareStatement(sql_update);
        sta.setInt(1,ID);
        sta.executeUpdate();
        System.out.println("权限升级成功");
        sta.close();
        con.close();
    }
    //变更为普通用户权限
    public void update_generous(int ID) throws SQLException {
        String sql_update="update user set identity=1 where id=?";
        sta=con.prepareStatement(sql_update);
        sta.setInt(1,ID);
        sta.executeUpdate();
        System.out.println("已变更为普通用户");
        sta.close();
        con.close();
    }
    //变更为游客身份
    public void update_tourist(int ID) throws SQLException {
        String sql_update="update user set identity=0 where id=?";
        sta=con.prepareStatement(sql_update);
        sta.setInt(1,ID);
        sta.executeUpdate();
        System.out.println("已变更为游客");
        sta.close();
        con.close();
    }
}
