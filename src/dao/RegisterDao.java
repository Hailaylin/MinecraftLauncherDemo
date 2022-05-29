package dao;

import com.mysql.cj.xdevapi.DbDoc;
import model.UserModel;

public class RegisterDao {
    // 目的：存数据库信息到model后有判断用户名密码与数据库是否一致的选项
    UserModel user;         // 用户信息
    DBUtil dbLoginDB;      // 数据库连接

    // 初始化数据库连接操作
    public RegisterDao(UserModel userIn) {
        dbLoginDB = new DBUtil();
        user = userIn;

    }

    // 使用存储的
    public void addUser() {
        try {
            // 读取用户
            // 连接到MYSQL
            UpdateDao up =new UpdateDao();
            up.insert(user);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}