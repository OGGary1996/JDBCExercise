package training.MVCExample1_HR.Service;

import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

import training.MVCExample1_HR.DAO.*;
import training.MVCExample1_HR.Model.*;

public class OfficesService {
    private OfficesDAO officesDAO;

    public OfficesService(OfficesDAO officesDAO){
        this.officesDAO = officesDAO;
    }

    // use method from EmployeesDAO 
    // .getOne(int id)
    public Offices getOfficeByID(int id) throws SQLException{
        Offices office = null;
            office = officesDAO.getOne(id);
            if (office == null){
                throw new SQLException("Office not fund!");
            }
            return office;
    }
    // .getAll()
    public List<Offices> getAllOffices() throws SQLException{
        List<Offices> offices = new ArrayList<>();
        offices = officesDAO.getAll();
        if (offices == null){
            throw new SQLException("Offices information not fund!");
        }
        return offices;
    }
    // .insert(Offices office)
    public int insertOffice(Offices office) throws SQLException{
        int result = officesDAO.insert(office);
        if (result == 0){
            throw new SQLException("Insert office failed!");
        }
        return result;
    }
    // .update(Offices office)
    public int updateOffice(Offices office) throws SQLException{
        int result = officesDAO.update(office);
        if (result == 0){
            throw new SQLException("Insert office failed!");
        }
        return result;
    }
    // .delet(int id)
    public int deleteOffice(int id) throws SQLException{
        int result = officesDAO.delete(id);
        if (result == 0){
            throw new SQLException("Delete office failed!");
        }
        return result;
    }

}
