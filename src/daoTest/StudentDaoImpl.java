  package daoTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    
	//FINDS AND RETURNS A RECORD USING AN ID --RETURNS A student object record displyed to the console in String format
	@Override
	public Student get(int id) throws SQLException {
		//1. create connection
		Connection connection = Database.getConnection();
		
		// set student object to null
		Student student= null;
		
		//3. create sql string
		String sql = "SELECT id, student_id, student_name FROM student WHERE id = ?";
		
		//4. create preparedStatement (lock and load)
		PreparedStatement ps = connection.prepareStatement(sql);
		
		//5. Set index to hold value assigned to placeholder
		ps.setInt(1, id);
		
		//6. return the Result set
		ResultSet result = ps.executeQuery();

		//7. check if records are available based on parameter
		while (result.next()) {
			int s_id = result.getInt("student_id");
			String s_name = result.getString("student_name");
			student = new Student(id,s_id,s_name); 
		}
		return student;
	}

	

	// INSERT METHOD -- RETURNS NUMBER OF RECORDS AFFECTED
	public int insert(Student student) throws SQLException {
		
		Connection connection = Database.getConnection();
		String sql1 = "INSERT INTO student(student_id, student_name)VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(sql1);
		
		//we need to get values for the parameters ?,?
		
		ps.setInt(1, student.getStudent_id());
		ps.setString(2, student.getStudent_Name());
		
		// return s the number of affected records
		int result = ps.executeUpdate();
		
		Database.closeConnection();
		Database.closePreparedStatement();
		
		
		return result;
	}

	
	//UPDATE METHOD --RETURNS NUMBER OF RECORDS AFFECTED
	@Override
	public int update(Student student) throws SQLException {
		
		Connection connection = Database.getConnection();
		
		String sql3 = "UPDATE student SET student_id = ? WHERE student_name = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql3);
		ps.setInt(1, student.getStudent_id());
		ps.setString(2, student.getStudent_Name() );

		int result = ps.executeUpdate();
		
		Database.closePreparedStatement();
		Database.closeConnection();
		
		return result;
		
		
	}

	
	//DELETE METHOD --RETURNS NUMBER OF RECORDS AFFECTED
	@Override
	public int delete(Student student) throws SQLException {
		Connection connection = Database.getConnection();
		String sql4 = "DELETE FROM student WHERE id = ? ";
		
		PreparedStatement ps = connection.prepareStatement(sql4);
		ps.setInt(1, student.getId());
		
		int result = ps.executeUpdate();
		
		Database.closePreparedStatement();
		Database.closeConnection();
		
		return result;
	}



	@Override
	public List<Student> getAll() throws SQLException {

		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}

}
