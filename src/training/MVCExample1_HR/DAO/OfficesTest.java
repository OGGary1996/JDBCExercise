package training.MVCExample1_HR.DAO;
import java.util.Scanner;

import training.MVCExample1_HR.Model.Offices;

import java.util.List;
import java.util.ArrayList;
public class OfficesTest {
    public static void main(String[] agrs){
        OfficesDAO officeDao = new OfficesDAOImpl();
        try{ // use .getOne() method to get a single object of type Offices
            Scanner inout = new Scanner(System.in);
            System.out.println("Type the office ID: ");
            int id = inout.nextInt();

            Offices oneOffice = null; // create an empty object of type Offices to store the result
            oneOffice = officeDao.getOne(id);

            if (oneOffice != null){
                System.out.println(oneOffice.getOfficeID() + " " + oneOffice.getAddress() + " " + oneOffice.getCity() + " " + oneOffice.getState());
            }else {
                System.out.println("Office not found");
            }
        }catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }

        try{
            List<Offices> allOffices = new ArrayList<>();
            allOffices = officeDao.getAll();
            
            for (Offices oneOffice : allOffices){
                System.out.println(oneOffice.getOfficeID() + " " + oneOffice.getAddress() + " " + oneOffice.getCity() + " " + oneOffice.getState());
            }
        }catch (Exception e){
            System.out.println("Something went wrong: " + e);
        }
    }
}
