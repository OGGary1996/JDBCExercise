package training;
// step1
import java.sql.*;
public class PracticeUpdate_1 {
    public static void main(String[] args) throws Exception{
        // step3
        String url = "jdbc:mysql://localhost:3306/sql_store";
        String userName = "root";
        String passWord = "Zk48658345@1996";
        Connection con = DriverManager.getConnection(url,userName,passWord);

        // step4
        Statement st = con.createStatement();

        // step5
        String sql1 = "INSERT INTO customers (first_name, last_name, birth_date, phone, address, city, state, points) VALUES ('John', 'Doe', '1986-07-12', '408-123-4567', '123 Main St', 'San Jose', 'CA', 0)";
        String sql2 = "UPDATE customers SET first_name = 'ke' WHERE customer_id = 11";
        int count = st.executeUpdate(sql1) + st.executeUpdate(sql2);
        
        // step6
        System.out.println(count + " row/s affected");

        // step7
        st.close();
        con.close();
    }
}