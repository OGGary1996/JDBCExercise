package training.MVCExample1_HR.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.MVCExample1_HR.DAO.*;
import training.MVCExample1_HR.Model.*;

public class EmployeesService {
    private EmployeesDAO employeesDAO = null;

    public EmployeesService(EmployeesDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    // use method from EmployeesDAO 
    // .getOne(int id)
    public Employees getEmployeeByID(int id) throws SQLException{
        Employees employee = null;
        employee = employeesDAO.getOne(id);
        if (employee == null){
            throw new SQLException ("Employee not fund!");
        }
        return employee;
    }
    // .getAll()
    public List<Employees> getAllEmployees() throws SQLException{
        List<Employees> employees = new ArrayList<>();
        employees = employeesDAO.getAll();
        if (employees == null){
            throw new SQLException ("Employees information is empty!");
        }
        return employees;
    }
    //.inert(Employees employee)
    public int insertEmployee(Employees employee) throws SQLException{
        int result = employeesDAO.insert(employee);
        if (result == 0) {
            throw new SQLException("Insert records failed.");
        }
        return result;
    }
    //.updata(Employees employee)
    public int updateEmployee(Employees employee) throws SQLException{
        int result = employeesDAO.update(employee);
        if (result == 0) {
            throw new SQLException("Insert records failed!");
        }
        return result;
    }
    // .delete(int id)
    public int deleteEmployee(int id) throws SQLException{
        int result = employeesDAO.delete(id);
        if (result == 0){
            throw new SQLException("Delete employee failed!");
        }
        return result;
    }
}
