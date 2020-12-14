package entities;

public class Teacher extends Person {
    public Teacher(){}
    public Teacher(String fname, String lname, int id) {
        super(fname, lname, id);
    }
//    private String fname;
//    private String lname;
//    private int teacherId;

//    public Teacher() {
//    }

//    public Teacher(int teacherId ,String fname, String lname) {
//        this.fname = fname;
//        this.lname = lname;
//        this.teacherId = teacherId;
//    }
//
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
//    public int getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(int teacherId) {
//        this.teacherId = teacherId;
//    }

    @Override
    public String toString() {
        return "Teacher "+"\n" +super.toString();
    }
}
