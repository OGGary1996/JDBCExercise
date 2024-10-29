package training;
// step1
import java.sql.*;
public class PracticeUpdate_2 {
    public static void main(String[] args) throws Exception {
        // step3 
        String url = "jdbc:mysql://localhost:3306/sql_store";
        String userName = "root";
        String passWord = "Zk48658345@1996";
        Connection con = DriverManager.getConnection(url,userName,passWord);

        // step4
        // 使用.prepareStatement()方法来创建PreparedStatement对象
        // 需要先创建一个sql语句的模板，然后再将参数传递给模板，预先编译sql语句，然后再执行后续的.executeUpdate()方法
        String sql1 = "INSERT INTO customers() VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)"; 
        PreparedStatement pst1 = con.prepareStatement(sql1);
        // 设置？的值
        pst1.setInt(1, 15);
        pst1.setString(2, "John");
        pst1.setString(3, "Doe");
        pst1.setString(4, "1986-07-12");
        pst1.setString(5, "408-123-4567");
        pst1.setString(6, "123 Main St");
        pst1.setString(7, "San Jose");
        pst1.setString(8, "CA");
        pst1.setInt(9, 0);

        String sql2 = "UPDATE customers SET first_name = ? WHERE customer_id = ?";
        PreparedStatement pst2 = con.prepareStatement(sql2);
        pst2.setString(1, "shiyu");
        pst2.setInt(2, 15);

        // step5
        int count = pst1.executeUpdate() + pst2.executeUpdate();

        // step6
        System.out.println(count + " row/s affected");

        // step7
        pst1.close();
        pst2.close();
        con.close();
    
    }
}
