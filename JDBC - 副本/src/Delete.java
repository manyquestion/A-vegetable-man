import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

         public class Delete {

             public static void main(String[] args) throws ClassNotFoundException, SQLException  {
                 String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
                 String USER="root";
                 String PASSWORD="HUMGwasdjkl";
                 //1.加载驱动程序
                 Class.forName("com.mysql.jdbc.Driver");
                 //2.获得数据库链接
                 Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
                 //3.通过数据库的连接操作数据库
                 String s="delete from user where id=2 and user_name=?";
                 PreparedStatement pst=conn.prepareStatement(s);

                 pst.setString(1, "xiaoshuai1");
                 //pst.setString(2, "123");

                 pst.execute();
                 //关闭资源
                 pst.close();
                 conn.close();
         }
}
