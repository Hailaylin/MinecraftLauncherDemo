package dao;

import db.LoginDB;
import model.ServerModel;

import java.sql.SQLException;

public class ServerDao {
    ServerModel server;
    //公告信息
    DBUtil dbUtil;
    //数据库连接
    public ServerDao(){
        dbUtil=new DBUtil();
    }

    /**
     * 获取公告信息
     * */
    public ServerModel getNotice() throws SQLException {
        return server;
    }

    /**
     * 写入公告信息
     * **/
    public void setNotice(ServerModel ser) throws SQLException {
        String sql="insert into servers(notice,serverAddr) values(?,?) ";
        dbUtil.sta= dbUtil.con.prepareStatement(sql);
        dbUtil.sta.setString(1,ser.getNotice());
        dbUtil.sta.setString(2,ser.getServeraddr());
        dbUtil.sta.executeUpdate();
        System.out.println("添加公告成功");
        dbUtil.sta.close();
        dbUtil.con.close();
    }
}
