package training.MVCExample1_HR.DAO;

import java.sql.*;
import java.util.List;

import training.MVCExample1_HR.Model.Offices;

import java.util.ArrayList;

public class OfficesDAOImpl implements OfficesDAO{ // implement the interface OfficesDAO
    @Override
    public Offices getOne(int id) throws SQLException{ // get a single object of type Offices
        Connection DBconnection = DatabaseHR.getConnection();

        String sql = "SELECT * FROM offices WHERE office_id = ?";
        PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
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

        try{ // close resources in try-catch block, ensure that resources are closed even if an exception is thrown
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
            result.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " + e);
        }finally{
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
            result.close();
        }

        return office;// return the object of type Offices
    }

    @Override 
    public List<Offices> getAll() throws SQLException{
        Connection DBconnection = DatabaseHR.getConnection();

        String sql = "SELECT * FROM offices";
        PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        
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

        try{ // close resources in try-catch block, ensure that resources are closed even if an exception is thrown
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
            results.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " + e);
        }finally{
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
            results.close();
        }

        return officeList;
    }

    @Override
    public int insert(Offices office) throws SQLException{
        Connection DBconnection = DatabaseHR.getConnection();
        
        String sql = "INSERT INTO offices () VALUES (?,?,?,?)";
        PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        SQLstatement.setInt(1,office.getOfficeID());
        SQLstatement.setString(2,office.getAddress());
        SQLstatement.setString(3,office.getCity());
        SQLstatement.setString(4,office.getState());

        int result = SQLstatement.executeUpdate();
        
        try{
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e);
        }finally{
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
        }

        return result;
    }

    @Override
    public int update(Offices office) throws SQLException{
        Connection DBconnection = DatabaseHR.getConnection();
        String sql = "UPDATE offices SET address = ?, city = ?, state = ? WHERE office_id = ?";
        PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        SQLstatement.setString(1,office.getAddress());
        SQLstatement.setString(2,office.getCity());
        SQLstatement.setString(3,office.getState());
        SQLstatement.setInt(4,office.getOfficeID());

        int result = SQLstatement.executeUpdate();

        try{
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e);
        }finally {
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
        }

        return result;
    }

    @Override
    public int delete(int id) throws SQLException{
        Connection DBconnection = DatabaseHR.getConnection();
        String sql = "DELETE FROM offices WHERE office_id = ?";
        PreparedStatement SQLstatement = DBconnection.prepareStatement(sql);
        SQLstatement.setInt(1,id);

        int result = SQLstatement.executeUpdate();

        try{
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e);
        }finally {
            DatabaseHR.closeConnection();
            DatabaseHR.closeStatement();
        }

        return result;
    }

}
