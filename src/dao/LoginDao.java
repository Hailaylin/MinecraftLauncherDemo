package dao;

import db.LoginDB;
import model.UserModel;

public class LoginDao {
    // 目的：存数据库信息到model后有判断用户名密码与数据库是否一致的选项
    UserModel user;         // 用户信息
    LoginDB dbLoginDB;      // 数据库连接

    // 初始化数据库连接操作
    public LoginDao() {
        dbLoginDB = new LoginDB();
    }

    // 判断输入的user和数据库的user是否一样,一样则获取数据到user Model中，返回用户类型
    // -1 密码不正确，其余返回用户类型
    public int judgeUserNamePwd(String userName, String pwd){
        try{
            user = dbLoginDB.getUserDB(userName);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        if(user.getUserPasswd().equals(pwd)){
            return user.getIdentity();
        }
        else{
            return -1;
        }
    }

    // 获取保存的用户信息
    public UserModel getUserModel(){
        return user;
    }
}
