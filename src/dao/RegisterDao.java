package dao;

import db.RegisterDB;
import model.UserModel;

public class RegisterDao {
    // 目的：存数据库信息到model后有判断用户名密码与数据库是否一致的选项
    UserModel user;         // 用户信息
    RegisterDB dbLoginDB;      // 数据库连接

    // 初始化数据库连接操作
    public RegisterDao(UserModel userIn) {
        dbLoginDB = new RegisterDB();
        user = userIn;

    }

    // 使用存储的
    public void addUser() {
        try {
            // 读取用户
            // 连接到MYSQL
            RegisterDB registerDB = new RegisterDB();
            registerDB.insertUserDB(user);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}