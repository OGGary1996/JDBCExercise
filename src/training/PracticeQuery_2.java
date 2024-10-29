package training;
//step1
import java.sql.*;
public class PracticeQuery_2 {
    public static void main(String[] args) throws Exception{
    // step2 在jdbc的更高版本中，不需要显式的注册驱动，因为在DriverManager的源码中已经注册了驱动
    // step3
    String url = "jdbc:mysql://localhost:3306/sql_store";
    String userName = "root";
    String passWord = "Zk48658345@1996";
    Connection con = DriverManager.getConnection(url,userName,passWord);
    
    // step4
    Statement st = con.createStatement();
    // step5
    String sql = "SELECT customer_id, first_name, last_name FROM customers";
    ResultSet result = st.executeQuery(sql);
    // step6
    while (result.next()){
        int customer_id = result.getInt("customer_id"); // 可直接使用column的编号替代名称，从1开始
        String first_name = result.getString("first_name");
        String last_name = result.getString("last_name");
        System.out.println("customer_id: " + customer_id + ", first_name: " + first_name + ", last_name: " + last_name);
    }

    // step7
    result.close();
    st.close();
    con.close();
    } 
}
