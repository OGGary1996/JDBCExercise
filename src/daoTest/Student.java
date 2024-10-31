package daoTest;

public class Student {
private int id;
private int student_id;
private String student_name;


public Student(int id, int student_id, String student_Name) {
	this.id = id;
	this.student_id = student_id;
	this.student_name = student_Name;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getStudent_id() {
	return student_id;
}


public void setStudent_id(int student_id) {
	this.student_id = student_id;
}


public String getStudent_Name() {
	return student_name;
}


public void setStudent_Name(String student_Name) {
	student_name = student_Name;
}


@Override
public String toString() {
	return "Student [id=" + id + ", student_id=" + student_id + ", student_name=" + student_name + "]";
}




}
