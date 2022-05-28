package db;

import java.sql.*;

//管理员权限
class manager {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="mcldb";
    private static String password="mcldbpwd";
    private java.sql.Connection con;
    private PreparedStatement sta;
    // 驱动和连接数据库
    public manager(){
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

    //添加公告信息
    public void set_notice(String no,String Addr) throws SQLException {
        String sql_add="insert into servers(notice,serverAddr) values(?,?) ";
        sta= con.prepareStatement(sql_add);
        sta.setString(1,no);
        sta.setString(2,Addr);
        sta.executeUpdate();
        System.out.println("添加公告链接成功");
    }
    //查看公告信息
    public void visit_notice() throws SQLException {
        String sql_select="select * from servers ";
        sta= con.prepareStatement(sql_select);
        ResultSet show = sta.executeQuery();
        String notice,serverAddr;
        int server_id;
        while(show.next()){
            server_id=show.getInt(1);
            notice=show.getString(2);
            serverAddr=show.getString(3);
            System.out.println(server_id+"\t"+notice+"\t"+serverAddr);
        }
    }
    //获取某一公告的链接
    public String get_notice(int id) throws SQLException {
        String sql_select=new String("select serverAddr from servers where server_id="+id);
        sta= con.prepareStatement(sql_select);
        ResultSet show = sta.executeQuery();
        show.next();
        System.out.println(show.getString(1));
        return show.getString(1);
    }

    //查看游客信息
    public void visit_tourist() throws SQLException {
        String sql_select="select * from user where identity=0";
        sta= con.prepareStatement(sql_select);
        ResultSet show= sta.executeQuery();
        String userName,userEmail,userPassword,loginServerPremission,latestLoginTime;
        int ID,loginTimes;
        int identity;
        Date lastestLoginTime;
        Time latestLoginTime1;

        while(show.next()) {
            ID=show.getInt(1);
            userName=show.getString(2);
            userEmail=show.getString(3);
            userPassword=show.getString(4);
            lastestLoginTime=show.getDate(5);
            latestLoginTime1=show.getTime(5);
            loginServerPremission=show.getString(6);
            identity=show.getInt(7);
            loginTimes=show.getInt(8);
            System.out.println(ID+"\t"+userName+"\t"+userEmail+"\t"+userPassword+"\t"+lastestLoginTime+" "+latestLoginTime1+"\t"+loginServerPremission+"\t"+identity+"\t"+loginTimes);
        }
    }

    //查看普通用户信息
    public void visit_user_general() throws SQLException {
        String sql_select="select * from user where identity=1";
        sta= con.prepareStatement(sql_select);
        ResultSet show= sta.executeQuery();
        String userName,userEmail,userPassword,loginServerPremission,latestLoginTime;
        int ID,loginTimes;
        int identity;
        Date lastestLoginTime;
        Time latestLoginTime1;

        while(show.next()) {
            ID=show.getInt(1);
            userName=show.getString(2);
            userEmail=show.getString(3);
            userPassword=show.getString(4);
            lastestLoginTime=show.getDate(5);
            latestLoginTime1=show.getTime(5);
            loginServerPremission=show.getString(6);
            identity=show.getInt(7);
            loginTimes=show.getInt(8);
            System.out.println(ID+"\t"+userName+"\t"+userEmail+"\t"+userPassword+"\t"+lastestLoginTime+" "+latestLoginTime1+"\t"+loginServerPremission+"\t"+identity+"\t"+loginTimes);
        }
    }
    //查看管理员信息
    public void visit_user_admin() throws SQLException {
        String sql_select="select * from user where identity=2";
        sta= con.prepareStatement(sql_select);
        ResultSet show= sta.executeQuery();
        String userName,userEmail,userPassword,loginServerPremission,latestLoginTime;
        int ID,loginTimes;
        int identity;
        Date lastestLoginTime;
        Time latestLoginTime1;

        while(show.next()) {
            ID=show.getInt(1);
            userName=show.getString(2);
            userEmail=show.getString(3);
            userPassword=show.getString(4);
            lastestLoginTime=show.getDate(5);
            latestLoginTime1=show.getTime(5);
            loginServerPremission=show.getString(6);
            identity=show.getInt(7);
            loginTimes=show.getInt(8);
            System.out.println(ID+"\t"+userName+"\t"+userEmail+"\t"+userPassword+"\t"+lastestLoginTime+" "+latestLoginTime1+"\t"+loginServerPremission+"\t"+identity+"\t"+loginTimes);
        }
    }
    //查看所有用户信息
    public void visit_user() throws SQLException {
        String sql_select="select * from user ";
        sta= con.prepareStatement(sql_select);
        ResultSet show= sta.executeQuery();
        String userName,userEmail,userPassword,loginServerPremission,latestLoginTime;
        int ID,loginTimes;
        int identity;
        Date lastestLoginTime;
        Time latestLoginTime1;

        while(show.next()) {
            ID=show.getInt(1);
            userName=show.getString(2);
            userEmail=show.getString(3);
            userPassword=show.getString(4);
            lastestLoginTime=show.getDate(5);//返回日期
            latestLoginTime1=show.getTime(5);//返回时间
            loginServerPremission=show.getString(6);
            identity=show.getInt(7);
            loginTimes=show.getInt(8);
            System.out.println(ID+"\t"+userName+"\t"+userEmail+"\t"+userPassword+"\t"+lastestLoginTime+" "+latestLoginTime1+"\t"+loginServerPremission+"\t"+identity+"\t"+loginTimes);
        }
    }

}
