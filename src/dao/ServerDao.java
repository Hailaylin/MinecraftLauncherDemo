package dao;

import db.LoginDB;
import model.ServerModel;

import java.sql.SQLException;

public class ServerDao {
    ServerModel server;
    //公告信息
    LoginDB logindb;
    //数据库连接
    public ServerDao(){
        logindb=new LoginDB();
    }


    /**
     * 获取公告信息
     * */
    public ServerModel getNotice() throws SQLException {
        server=logindb.getSever();

        return server;
    }

    /**
     *
     * */
    public int changeNotice(ServerModel ser) throws SQLException {
        logindb.set_notice(ser);
        return 0;
    }
}
