package training.MVCExample1_HR.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import training.MVCExample1_HR.Model.*;
import training.MVCExample1_HR.Service.*;
import training.MVCExample1_HR.View.EmployeesView;

public class EmployeesController {
    private EmployeesService employeesService;
    private EmployeesView employeesView;
    private Scanner scanner;

    public EmployeesController(EmployeesService employeesService , EmployeesView employeesView){
        this.employeesService = employeesService;
        this.employeesView = employeesView;
        this.scanner = new Scanner(System.in);
    }
    
    public void run(){
        while (true){
            System.out.println("Input your choice(1-5):");
            System.out.println("1. Search one employee's information.");
            System.out.println("2. Search all employees' information.");
            System.out.println("3. Insert one employee's information.");
            System.out.println("4. Update one employee's information.");
            System.out.println("5. Delete one employee's information.");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: 
                getEmployeeByID();
                break;
                case 2:
                getAllEmployees();
                break;
                case 3:
                insertEmployee();
                break;
                case 4:
                updateEmployee();
                break;
                case 5:
                deleteEmployee();
                break;
                default:
                System.out.println("Invalid input, please input again!");
            }
        }
    }

    public void getEmployeeByID(){
        int id = 0;
        while(true){
            System.out.println("Please input the employee's id:");
            if (scanner.hasNextInt()){ // hasNextInt()方法判断是否有下一个整数
                id = scanner.nextInt(); // nextInt()方法获取下一个整数
                scanner.nextLine();
                break;
            }else {
                System.out.println("Invalid id, please input again!");
                scanner.nextLine();
            }
        }
        
        try {
            Employees employee = employeesService.getEmployeeByID(id);
            employeesView.displayEmployee(employee);
        } catch (SQLException e) {
            System.out.println("Something wrong: " + e.getMessage()); 
        }

    }

    public void getAllEmployees(){
        try {
            List<Employees> employees = employeesService.getAllEmployees();
            employeesView.displayAllEmployees(employees);
        } catch (SQLException e) {
            System.out.println("Something wrong: " + e.getMessage()); 
        }
    }

    public void insertEmployee(){
        Employees employee = new Employees();
        System.out.println("Please input the employee's id:");
        employee.setEmployeeID(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please input the employee's first name:");
        employee.setFirstName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Please input the employee's last name:");
        employee.setLastName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Please input the employee's email:");
        employee.setJobTitle(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Please input the employee's salary:");
        employee.setSalary(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please input the employee's reports to:");
        employee.setReportsTo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please input the employee's office id:");
        employee.setOfficeID(scanner.nextInt());
        scanner.nextLine();

        try {
            int result = employeesService.insertEmployee(employee);
            employeesView.displayMessage(result);
        }catch (SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    public void updateEmployee(){
        Employees employee = new Employees();
        System.out.println("Please input the employee's id:");
        employee.setEmployeeID(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please input the employee's first name:");
        employee.setFirstName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Please input the employee's last name:");
        employee.setLastName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Please input the employee's email:");
        employee.setJobTitle(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Please input the employee's salary:");
        employee.setSalary(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please input the employee's reports to:");
        employee.setReportsTo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please input the employee's office id:");
        employee.setOfficeID(scanner.nextInt());
        scanner.nextLine();

        try {
            int result = employeesService.updateEmployee(employee);
            employeesView.displayMessage(result);
        }catch(SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    public void deleteEmployee(){
        int id = 0;
        while(true){
            System.out.println("Please input the employee's id:");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            }else {
                System.out.println("Invalid id, please input again!");
                scanner.nextLine();
            }
        }

        try {
            int result = employeesService.deleteEmployee(id);
            employeesView.displayMessage(result);
        }catch(SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }
}
