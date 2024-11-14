package training.MVCExample1_HR.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import training.MVCExample1_HR.Model.Employees;
public class EmployeesTest {
    public static void main(String[] args){
        EmployeesDAO employeesDao = new EmployeesDAOImpl();
        try { // use .getOne() method to get a single employee
            Scanner input = new Scanner(System.in);
            System.out.println("Type the employee ID: ");
            int idToFind = input.nextInt();

            Employees oneEmployee = null; // create an object of type Employees to store the result of the .getOne() method
            oneEmployee = employeesDao.getOne(idToFind);
           
            if (oneEmployee != null){
            System.out.println(oneEmployee.getFirstName() + " " + oneEmployee.getLastName() +" " + oneEmployee.getJobTitle() + " " + oneEmployee.getSalary() + " " + oneEmployee.getReportsTo() + " " + oneEmployee.getOfficeID());
            }else {
                System.out.println("Employee not found");
            }
        }catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }

        try { // use .getAll() to get all the records from the table employees
            List<Employees> allEmployees = new ArrayList<>();
            allEmployees = employeesDao.getAll();
            for (Employees oneEmployee : allEmployees){
                System.out.println(oneEmployee.getFirstName() + " " + oneEmployee.getLastName() +" " + oneEmployee.getJobTitle() + " " + oneEmployee.getSalary() + " " + oneEmployee.getReportsTo() + " " + oneEmployee.getOfficeID());
            }    
        }catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }
    }
}
