package dao;

import model.UserModel;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDao {
    DBUtil dbUtil;
    UserModel user;
    java.sql.Connection con;
    PreparedStatement sta;

    public UpdateDao() {
        dbUtil = new DBUtil();
        user = new UserModel();
        con = dbUtil.con;
        sta = dbUtil.sta;
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

    //删除用户
    public void delete_name(String name) throws SQLException {
        String sql="delete  from user where username=?";
        sta=con.prepareStatement(sql);
        sta.setString(1,name);
        sta.executeUpdate();
        System.out.println("玩家删除成功");
        JOptionPane.showMessageDialog(null, "玩家删除成功","删除成功",JOptionPane.INFORMATION_MESSAGE);
        sta.close();
        con.close();
    }
    //更新邮箱
    public static void update_email(String email, int ID) throws SQLException {
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
