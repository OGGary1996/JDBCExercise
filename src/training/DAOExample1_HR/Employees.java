package training.DAOExample1_HR;

public class Employees { 
    // create a class named Employees, which is used for creating objects of type Employees
    private int employee_id;
    private String first_name;
    private String last_name;
    private String job_title;
    private int salary;
    private int reports_to;
    private int office_id;

    // constructor 1
    public Employees() {
    }

    // constructor 2
    public Employees(int employee_id, String first_name, String last_name, String job_title, int salary, int reports_to, int office_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.job_title = job_title;
        this.salary = salary;
        this.reports_to = reports_to;
        this.office_id = office_id;
    }

    // getter and setter methods
    public int getEmplyeeID(){
        return employee_id;
    }

    public void setEmployeeID(int employee_id){
        this.employee_id = employee_id;
    }

    public String getFirstName(){
        return first_name;
    }
    
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }

    public String getLastName(){
        return last_name;
    }

    public void setLastName(String last_name){
        this.last_name = last_name;
    }

    public String getJobTitle(){
        return job_title;
    }

    public void setJobTitle(String job_title){
        this.job_title = job_title;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getReportsTo(){
        return reports_to;
    }   

    public void setReportsTo(int reports_to){
        this.reports_to = reports_to;
    }

    public int getOfficeID(){
        return office_id;
    }

    public void setOfficeID(int office_id){
        this.office_id = office_id;
    }

    // override toString method,to get the string representation of this object
    @Override
    public String toString(){
        return " HR [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name + ", job_title=" + job_title + ", salary=" + salary + ", reports_to=" + reports_to + ", office_id=" + office_id + "]";
    }
}
