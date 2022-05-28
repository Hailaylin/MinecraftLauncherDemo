package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    public static final String url="jdbc:mysql://localhost:3306/player_management";
    public static final String user ="mcldb";
    public static final String password="mcldbpwd";
    //类第一次加载的时候执行一次
    static {
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//有可能报错
    }
    //2.数据库链接
    public static Connection getConn() {
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(url, user, password);
//           System.out.println("数据库加载成功");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库加载失败");
        }return conn;
    }
    public static void close(Connection conn, PreparedStatement pst) {
        try {
            //5.关闭数据库
            conn.close();
            pst.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Connection conn=DBUtil.getConn();
//        System.out.println(conn);

}
