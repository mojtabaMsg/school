package entities;

public class Student extends Person{

    public Student(){}
    public Student(String fname, String lname, int id) {
        super(fname, lname, id);
    }

    @Override
    public String toString() {
        return "Student "+"\n" + super.toString();

    }

//    public String getFname() {
//        return fname;
//    }
//
//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//
//    public String getLname() {
//        return lname;
//    }
//
//    public void setLname(String lname) {
//        this.lname = lname;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
}
