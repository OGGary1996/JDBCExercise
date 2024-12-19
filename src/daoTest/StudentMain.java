 package daoTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentMain {
	

	public static void main(String[] args)throws SQLException {
		
	// CREATE TABLE ---This is just a label, delete or comment off before running code
	 Connection connection = Database.getConnection();
		String sql = "CREATE TABLE IF NOT EXISTS student(id int AUTO_INCREMENT, student_id int NOT NULL, Student_Name VARCHAR(30), PRIMARY KEY(id))";
		PreparedStatement prepardStatement = connection.prepareStatement(sql);
		prepardStatement.execute(sql); 
		
	//	RETRIEVE RECORD ---This is just a label, delete or comment off before running code
		// Execute retrieve method on StudentDAO
		
		StudentDao studentDao1 =  new StudentDaoImpl();
		Student student1 = studentDao1.get(3);
		System.out.println(student1);
	
		
	//	INSERT RECORD ---This is just a label, delete or comment off before running code
		//Call the INSERT method from StudentDAO
		
		StudentDao studentDao2 = new StudentDaoImpl();
		Student student2 = new Student(0,1235, "Daryl2");
		
		int result2 = studentDao2.insert(student2);
		
		System.out.println(result2); 
		
		
	//	UPDATE RECORD ---This is just a label, delete or comment off before running code
		
		//call the UPDATE method from StudentDAO
		
	
		StudentDao studentDao3 = new StudentDaoImpl();
		Student student3 = new Student(0,1000, "Daryl");
		
		int result3 = studentDao3.update(student3);
		
		System.out.println(result3); 
		
		
		
	//	DELETE RECORD ---This is just a label, delete or comment off before running code
		//call the Delete method from our DAO
		
		StudentDao studentDao4 = new StudentDaoImpl();
		@SuppressWarnings("unused")
		Student student4 = new Student(1,1000,"Daryl");
		Student student5 = studentDao4.get(3);
		System.out.println(student5);
		
		int result = studentDao4.delete(student5);
		
		System.out.println(result); 
		
	}

}
