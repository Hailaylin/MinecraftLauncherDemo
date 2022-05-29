package dao;

import model.UserModel;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    //创建用户
    //最新********误删
    public int insert(UserModel user) throws SQLException {

        String sql0="select * from user where username= '"+user.getUserName()+"';";
        System.out.println(sql0);
        Statement sta1=dbUtil.con.createStatement();
        ResultSet show= sta1.executeQuery(sql0);
        if(show.next()){
            JOptionPane.showMessageDialog(null, "玩家已存在！","请更换用户名",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        String sql="insert into user(userEmail,userPasswd,identity,userName) values" +
                "('"+user.getEmail()+"','"+user.getUserPasswd()+"',1,'"+user.getUserName()+"')";
        System.out.println(sql);
        Statement sta= dbUtil.con.createStatement();
        sta.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "玩家添加成功！","修改成功",JOptionPane.INFORMATION_MESSAGE);
        return 0;
    }


    //更新用户2.0版本
    //直接将model中的所有信息进行更新
    public int updata(UserModel user) throws SQLException {
        String sql="update user set  userEmail='"+user.getEmail()+"',userPasswd='"
                +user.getUserPasswd()+"',latestLoginTime=now(),identity="+user.getIdentity()+",LoginTimes=LoginTimes+1" +
                " where username='"+user.getUserName()+"';";
        System.out.println(sql);
        Statement sta= dbUtil.con.createStatement();
        sta.executeUpdate(sql);
        return 0;
    }


    //删除用户
    //******这个不能删
    //判断用户是否存在
    public void delete_name(String name) throws SQLException {
        String sql0="select * from user where username= '"+name+"';";
        System.out.println(sql0);
        Statement sta1=dbUtil.con.createStatement();
        ResultSet show= sta1.executeQuery(sql0);
        if(!show.next()){
            JOptionPane.showMessageDialog(null, "该玩家不存在！！","删除失败",JOptionPane.ERROR_MESSAGE);
        }
        else {
            String sql = "delete  from user where username=?";
            PreparedStatement sta;
            sta = dbUtil.con.prepareStatement(sql);
            sta.setString(1, name);
            sta.executeUpdate();
            JOptionPane.showMessageDialog(null, "玩家删除成功", "删除成功", JOptionPane.INFORMATION_MESSAGE);
            sta.close();
        }

    }



    //查询语句
    //查询有没有相同的用户名
    public void  select (String name) throws SQLException {
        String sql="select * from user where username= '"+name+"';";
        System.out.println(sql);
        Statement sta=dbUtil.con.createStatement();
        ResultSet show= sta.executeQuery(sql);
        if(show.next()){
            JOptionPane.showMessageDialog(null, "该玩家存在！！","查询结果",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "该玩家不存在！！","查询结果",JOptionPane.ERROR_MESSAGE);
        }
    }
}
