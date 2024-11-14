package training.MVCExample1_HR.DAO;
import java.sql.*;
public class DatabaseHR {
    private static Connection DBconnection = null; // set Connection object as null at first
    private static PreparedStatement SQLstatement = null; // set PreparedStatement object as null at first
    private static String url = "jdbc:mysql://localhost:3306/sql_hr"; 
    private static String userName = "root";
    private static String password = "Zk48658345@1996";
 
    public static Connection getConnection() throws SQLException{ // create a method to establish connection, and return this connection
        if (DBconnection == null){
            DBconnection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection established successfully");
        }else if (DBconnection != null){
            System.out.println("Connection already established");
        }
        return DBconnection;
    }

    public static void closeStatement() throws SQLException{  // create a method to close the statement
        if (SQLstatement != null){
            SQLstatement.close();
            System.out.println("Statement closed successfully");
        }else if (SQLstatement == null){
            System.out.println("Statement already closed");
        }
    }

    public static void closeConnection() throws SQLException{ // create a method to close the connection
        if (DBconnection != null){
            DBconnection.close();
            System.out.println("Connection closed successfully");
        }else if (DBconnection == null){
            System.out.println("Connection already closed");
        }
    }
}
