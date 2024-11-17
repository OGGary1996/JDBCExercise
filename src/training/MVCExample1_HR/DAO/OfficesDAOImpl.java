package training.MVCExample1_HR.DAO;

import java.sql.*;
import java.util.List;

import training.MVCExample1_HR.Model.Offices;

import java.util.ArrayList;

public class OfficesDAOImpl implements OfficesDAO{ // implement the interface OfficesDAO
    @Override
    public Offices getOne(int id) throws SQLException{ // get a single object of type Offices
        String sql = "SELECT * FROM offices WHERE office_id = ?";
        try(
            Connection DBconnection = DatabaseHR.getConnection();
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            SQLstatement.setInt(1,id);

            ResultSet result = SQLstatement.executeQuery();
            Offices office = null;
            while (result.next()){
                office = new Offices();
                office.setOfficeID(result.getInt("office_id"));
                office.setAddress(result.getString("address"));
                office.setCity(result.getString("city"));
                office.setState(result.getString("state"));
            }
            
            return office;// return the object of type Offices
        }
    }

    @Override 
    public List<Offices> getAll() throws SQLException{
        String sql = "SELECT * FROM offices";
        try(
            Connection DBconnection = DatabaseHR.getConnection();
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            ResultSet results = SQLstatement.executeQuery();
            List<Offices> officeList = new ArrayList<>();
            Offices office = null;
            while(results.next()){
                office = new Offices();
                office.setOfficeID(results.getInt("office_id"));
                office.setAddress(results.getString("address"));
                office.setCity(results.getString("city"));
                office.setState(results.getString("state"));
                officeList.add(office);
            }
            return officeList;
        }
    }

    @Override
    public int insert(Offices office) throws SQLException{
        String sql = "INSERT INTO offices () VALUES (?,?,?,?)";
        try(
            Connection DBconnection = DatabaseHR.getConnection();
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            SQLstatement.setInt(1,office.getOfficeID());
            SQLstatement.setString(2,office.getAddress());
            SQLstatement.setString(3,office.getCity());
            SQLstatement.setString(4,office.getState());
    
            int result = SQLstatement.executeUpdate();
    
            return result;
        }
    }

    @Override
    public int update(Offices office) throws SQLException{
        String sql = "UPDATE offices SET address = ?, city = ?, state = ? WHERE office_id = ?";
        try(
            Connection DBconnection = DatabaseHR.getConnection();
            PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        ){
            SQLstatement.setString(1,office.getAddress());
            SQLstatement.setString(2,office.getCity());
            SQLstatement.setString(3,office.getState());
            SQLstatement.setInt(4,office.getOfficeID());
    
            int result = SQLstatement.executeUpdate();
            
            return result;
        }
    }

    @Override
    public int delete(int id) throws SQLException{
        String sql = "DELETE FROM offices WHERE office_id = ?";
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
