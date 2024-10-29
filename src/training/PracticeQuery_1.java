package training;
// step1: import the package
// step2: load and register the driver
// step3: create connection
// step4: create statement
// step5: execute the query
// step6: process the results
// step7: close the connection

import java.sql.*;// step1
public class PracticeQuery_1 {
    public static void main(String[] args) throws Exception{
    // step2
       Class.forName("com.mysql.cj.jdbc.Driver"); 
    // step3 
    // Connection实际上是一个接口，不能直接实例化，所以要用DriverManager.getConnection()方法来获取Connection对象
       String url = "jdbc:mysql://localhost:3306/Wine";
       String userName = "root";
       String password = "Zk48658345@1996";
       Connection connection = DriverManager.getConnection(url, userName, password);
    // step4 
    // Statement实际上也是一个接口，不能直接实例化，所以要用Connection.createStatement()方法来获取Statement对象
    // 必须要在connection对象的基础上创建statement对象，因为statement对象是依赖于connection对象的
       Statement statement = connection.createStatement(); 
    // step5
    // 必须要在statement对象的基础上执行sql语句，因为sql语句是依赖于statement对象的
    // ResultSet的对象是一个结果集对象，用于封装查询结果
        String sql = "SELECT * FROM Winery";
        ResultSet result = statement.executeQuery(sql);
    // step6
    // .next()方法用于判断结果集中是否还有下一条记录，如果有，返回true，否则返回false
        while (result.next()){
            int winery_id = result.getInt("winery_id");
            String winery_name = result.getString("winery_name");
            int viticultural_area_id = result.getInt("viticultural_area_id");
            int Offering_tours_flag = result.getInt("Offering_tours_flag");
            System.out.println("winery_id: " + winery_id + ", winery_name: " + winery_name + ", viticultural_area_id: " + viticultural_area_id + ", Offering_tours_flag: " + Offering_tours_flag);
        }
    // step7
        result.close();
        statement.close();
        connection.close();
    }
}
