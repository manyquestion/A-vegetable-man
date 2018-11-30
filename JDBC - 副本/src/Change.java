import java.sql.*;


public class Change {

            public static void main(String[] args) throws ClassNotFoundException, SQLException  {
                 String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
                 String USER="root";
                 String PASSWORD="HUMGwasdjkl";
                 //1.加载驱动程序
                 Class.forName("com.mysql.jdbc.Driver");
                 //2.获得数据库链接
                 Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
                 //3.通过数据库的连接操作数据库
                 String s="select user_name,user_password from user where user_name=? and user_password=?";
                 PreparedStatement pst=conn.prepareStatement(s);

                 pst.setString(1, "xiao");
                 pst.setString(2, "123");
                 ResultSet rs=pst.executeQuery();
                 //4.处理数据库的返回结果
                 while(rs.next()){
                      System.out.println(rs.getString("user_name")+" " +rs.getString("user_password"));
                     }
                 //关闭资源
                 rs.close();
                 pst.close();
                 conn.close();
             }
}