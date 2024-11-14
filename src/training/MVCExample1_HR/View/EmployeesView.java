package training.MVCExample1_HR.View;

import java.util.List;
import training.MVCExample1_HR.Model.*;

public class EmployeesView {
    public void displayEmployee(Employees employee){
        employee.toString();
    }

    public void displayAllEmployees(List<Employees> employees){
        for (Employees employee : employees){
            employee.toString();
        }
    }

    public void displayMessage(int result){
        System.out.println("Your modification is successful, " + result + "records are affected.");
    }
}
