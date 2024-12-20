package training.MVCExample1_HR.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import training.MVCExample1_HR.Model.Employees;

public class EmployeesDAOImpl implements EmployeesDAO{
    @Override
    public Employees getOne(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE employee_id = ?"; // create a sql statement
        try(
            Connection DBconnection = DatabaseHR.getConnection(); // get connection based on the Database_hr class
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql); // create a PreparedStatement object

        ){
            SQLstatement.setInt(1, id); //  set the value of the first ? to the id
            ResultSet results = SQLstatement.executeQuery(); // execute the query and store the resultset in results
    
            Employees employee = null; // create an empty object of type Employees to store the resultset
            while (results.next()){
                employee = new Employees(); // create a new object of type Employees
                employee.setEmployeeID(results.getInt("employee_id")); // set the value of employee_id to the value of the column employee_id in the resultset
                employee.setFirstName(results.getString("first_name")); // set the value of first_name to the value of the column first_name in the resultset
                employee.setLastName(results.getString("last_name")); // set the value of last_name to the value of the column last_name in the resultset
                employee.setJobTitle(results.getString("job_title")); // set the value of job_title to the value of the column job_title in the resultset
                employee.setSalary(results.getInt("salary")); // set the value of salary to the value of the column salary in the resultset
                employee.setReportsTo(results.getInt("reports_to")); // set the value of reports_to to the value of the column reports_to in the resultset
                employee.setOfficeID(results.getInt("office_id")); // set the value of office_id to the value of the column office_id in the resultset
            };
            return employee; // return the object of type Employees
        }
    }

    @Override
    public List<Employees> getAll() throws SQLException{
        String sql = "SELECT * FROM employees";
        try(
            Connection DBconnection = DatabaseHR.getConnection(); // get connection based on the Database_hr class
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            ResultSet results = SQLstatement.executeQuery();
            List<Employees> employeeList = new ArrayList<>(); // create an empty list of type Employees to store the resultset
            Employees employee = null; // create an empty object of type Employees to store the resultset
            while (results.next()){
                employee = new Employees(); // create a new object of type Employees
                employee.setEmployeeID(results.getInt("employee_id")); // set the value of employee_id to the value of the column employee_id in the resultset
                employee.setFirstName(results.getString("first_name")); // set the value of first_name to the value of the column first_name in the resultset
                employee.setLastName(results.getString("last_name")); // set the value of last_name to the value of the column last_name in the resultset
                employee.setJobTitle(results.getString("job_title")); // set the value of job_title to the value of the column job_title in the resultset
                employee.setSalary(results.getInt("salary")); // set the value of salary to the value of the column salary in the resultset
                employee.setReportsTo(results.getInt("reports_to")); // set the value of reports_to to the value of the column reports_to in the resultset
                employee.setOfficeID(results.getInt("office_id")); // set the value of office_id to the value of the column office_id in the resultset
                employeeList.add(employee); // add the object to the list
            };
            return employeeList; // return the list of type Employees
        }
    }

    @Override
    public int insert(Employees employee) throws SQLException {
        String sql = "INSERT INTO employees() VALUES(?,?,?,?,?,?,?)";
        try(
            Connection DBconnection = DatabaseHR.getConnection(); 
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
        // set the parameters of sql, these parameters are from emlpoyee Object
            SQLstatement.setInt(1,employee.getEmplyeeID());
            SQLstatement.setString(2,employee.getFirstName());
            SQLstatement.setString(3,employee.getLastName());
            SQLstatement.setString(4,employee.getJobTitle());
            SQLstatement.setInt(5,employee.getSalary());
            SQLstatement.setInt(6,employee.getReportsTo());
            SQLstatement.setInt(7,employee.getOfficeID());

            int result = SQLstatement.executeUpdate();
            return result;
        }
    }

    @Override
    public int update(Employees employee) throws SQLException{
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, job_title = ?, salary = ?, reports_to = ?, office_id = ? WHERE employee_id = ?";
        try(
            Connection DBconnection = DatabaseHR.getConnection();
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            SQLstatement.setString(1,employee.getFirstName());
            SQLstatement.setString(2,employee.getLastName());
            SQLstatement.setString(3,employee.getJobTitle());
            SQLstatement.setInt(4,employee.getSalary());
            SQLstatement.setInt(5,employee.getReportsTo());
            SQLstatement.setInt(6,employee.getOfficeID());
            SQLstatement.setInt(7,employee.getEmplyeeID());
            
            int result = SQLstatement.executeUpdate();
            
            return result;
        }
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE employee_id = ? ";
        try(
            Connection DBconnection = DatabaseHR.getConnection();
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            SQLstatement.setInt(1,id);

            int result = SQLstatement.executeUpdate();
    
            return result;
        }
    }
}
