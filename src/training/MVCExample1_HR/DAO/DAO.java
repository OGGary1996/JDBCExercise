package training.MVCExample1_HR.DAO;
import java.util.List;
import java.sql.SQLException;
public interface DAO<T> { // type T is a placeholder for any type, this interface is a generic interface
    // declare CRUD operations
    T getOne(int id) throws SQLException; // get a single object of type T
    List<T> getAll() throws SQLException; // get all objects of type T
    int insert(T t) throws SQLException; // insert a single object of type T
    int update(T t) throws SQLException; // update a single object of type T
    int delete(int id) throws SQLException; // delete a single object of type T
}
