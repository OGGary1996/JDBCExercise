package training.MVCExample1_HR.DAO;
import java.sql.*;
public class DatabaseHR {
    private static String url = "jdbc:mysql://localhost:3306/sql_hr"; 
    private static String userName = "root";
    private static String password = "Zk48658345@1996";
 
    public static Connection getConnection() throws SQLException{ // create a method to establish connection, and return this connection
        return DriverManager.getConnection(url, userName, password);
    }
}
