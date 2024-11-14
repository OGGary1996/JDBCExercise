package training.MVCExample1_HR.View;
import java.util.List;
import training.MVCExample1_HR.Model.*;
public class OfficesView {
    public void displayOffice(Offices office){
        office.toString();
    }

    public void displayAllOffices(List<Offices> offices){
        for (Offices office : offices){
            office.toString();
        }
    }

    public void displayMessage(int result){
        System.out.println("Your modification is successful, " + result + "records are affected.");
    }
}
