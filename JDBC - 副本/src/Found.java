import java.sql.*;


public class Found {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="HUMGwasdjkl";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.实现增删改查
        String s="select ?,? from user where user_name=xiao and user_password=123";
        PreparedStatement pst=conn.prepareStatement(s);

        pst.setString(1, "user_name");
        pst.setString(2, "user_password");
        ResultSet rs=pst.executeQuery();
        //4.处理数据库的返回结果(使用ResultSet类)

        System.out.println(rs.getString("user_name")+" " +rs.getString("user_password"));

        //关闭资源
        rs.close();
        pst.close();
        conn.close();
    }
}
