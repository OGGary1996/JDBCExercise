package training.MVCExample1_HR.Controller;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import training.MVCExample1_HR.Model.*;
import training.MVCExample1_HR.Service.*;
import training.MVCExample1_HR.View.OfficesView;

public class OfficesController {
    private OfficesService officesService;
    private OfficesView officesView;
    private Scanner scanner;

    public OfficesController(OfficesService officesService , OfficesView officeView){
        this.officesService = officesService;
        this.officesView = officeView;
        this.scanner = new Scanner(System.in);
    }
    
    public void run(){
        while(true){
            System.out.println("Please input your choice(1-5):");
            System.out.println("1. Search one office's information.");
            System.out.println("2. Search all offices' information.");
            System.out.println("3. Insert one office's information.");
            System.out.println("4. Update one office's information.");
            System.out.println("5. Delete one office's information.");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                getOfficeByID();
                break;
                case 2:
                getAllOffices();
                break;
                case 3:
                insertOffice();
                break;
                case 4:
                updateOffice();
                break;
                case 5:
                deleteOffice();
                break;
                default:
                System.out.println("Invalid input, please input again!");
            }
        }
    }

    public void getOfficeByID(){
        int id = 0;
        while(true){
            System.out.println("Please input the office's id:");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            }else {
                System.out.println("Invalid id, please input again!");
                scanner.nextLine();
                continue;
            }
        }

        try {
            Offices office = officesService.getOfficeByID(id);
            officesView.displayOffice(office);
        }catch (SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    public void getAllOffices(){
        try {
            List<Offices> offices = officesService.getAllOffices();
            officesView.displayAllOffices(offices);
        }catch(SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    public void insertOffice(){
        Offices office = new Offices();
        System.out.println("Please input the office's information:");
        System.out.println("Office ID:");
        office.setOfficeID(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Address:");
        office.setAddress(scanner.nextLine());
        scanner.nextLine();
        System.out.println("City:");
        office.setAddress(scanner.nextLine());
        scanner.nextLine();
        System.out.println(scanner.nextLine());
        scanner.nextLine();
        System.out.println("State:");
        office.setState(scanner.nextLine());
        scanner.nextLine();
        
        try{
            int result = officesService.insertOffice(office);
            officesView.displayMessage(result);
        }catch(SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    public void updateOffice(){
        Offices office = new Offices();
        System.out.println("Please input the office's information:");
        System.out.println("Office ID:");
        office.setOfficeID(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Address:");
        office.setAddress(scanner.nextLine());
        scanner.nextLine();
        System.out.println("City:");
        office.setAddress(scanner.nextLine());
        scanner.nextLine();
        System.out.println(scanner.nextLine());
        scanner.nextLine();
        System.out.println("State:");
        office.setState(scanner.nextLine());
        scanner.nextLine();
        
        try{
            int result = officesService.updateOffice(office);
            officesView.displayMessage(result);
        }catch(SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    public void deleteOffice(){
        int id = 0;
        while(true){
            System.out.println("Please input the office's id:");
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
            int result = officesService.deleteOffice(id);
            officesView.displayMessage(result);
        }catch(SQLException e){
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

}
