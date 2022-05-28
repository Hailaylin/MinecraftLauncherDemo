package dao;

import until.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDao {
    public String name;
    public String password;
    protected String confirmpassword;
    protected String mail;

    public void setname(String name) {
        this.name = name;
    }
    public void setmail(String mail) {
        this.mail = mail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    public boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        if (this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "用户名", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //符合规则，弹出注册成功的窗口，并将账号添加数据库
        JOptionPane.showMessageDialog(null, "注册成功");
        userAdd();
        return true;
    }
    public void userAdd() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO test (name,password)" + "VALUES (?,?)";
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.name);
            ps.setString(2, this.password);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("添加用户失败！");
        }
    }


}

