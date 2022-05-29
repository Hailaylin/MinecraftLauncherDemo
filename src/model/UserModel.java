package model;

public class UserModel {
    // 玩家数据
    private int id;
    private String userName;
    private String userPasswd;
    private int identity;       // 用户权限012，0游客，1玩家，2管理员
    private String email;       // 邮箱信息

    public UserModel() {
    }

    public UserModel( String userName, String userPasswd, int identity, String email) {

        this.userName = userName;
        this.userPasswd = userPasswd;
        this.identity = identity;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
