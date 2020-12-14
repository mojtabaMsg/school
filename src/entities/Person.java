package entities;

public class Person {
    private String fname;
    private String lname;
    private int id;

    public Person(){}

    public Person(String fname, String lname, int id) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
    }

    @Override
    public String toString() {
        return  "FirstName :" + fname + "\n" +
                "LastName :" + lname + "\n" +
                "StudentId :" + id + "\n";

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
