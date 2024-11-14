package training.MVCExample1_HR.Model;

public class Offices { 
    // create a class named Offices, which is used for creating objects of type Offices
    private int office_id;
    private String address;
    private String city;
    private String state;

    // constructor1
    public Offices() { 
    }
    // constructor2
    public Offices(int office_id, String address, String city, String state) { 
        this.office_id = office_id;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    // getter and setter methods
    public int getOfficeID(){
        return office_id;
    }

    public void setOfficeID(int office_id){
        this.office_id = office_id;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    // toString method, which returns the string representation of the object
    @Override
    public String toString() {
        return "Offices{" +
                "office_id=" + office_id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
