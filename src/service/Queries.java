package service;

public class Queries {
    //loading
    private static String teacherLoad = "SELECT * from teacher";
    private static String studentLoad = "SELECT * from student";

    //adding
    private static String teacherAdd = "INSERT INTO teacher  (`idTeacher`,`fname` ,`lname`) VALUES (?, ?, ?); ";
    private static String studentAdd = "INSERT INTO student  (`idStudent`,`fname` ,`lname`) VALUES (?, ?, ?); ";

    //updating
    private static String teacherUpdate = "UPDATE `teacher` SET `fname` = ? , `lname` = ?" +"\n" +
            "                             WHERE (`idteacher` =?);";

    private static String studentUpdate = "UPDATE `student` SET `fname` = ? , `lname` = ?" +"\n" +
                                           " WHERE (`idstudent` =?);";

    //deleting
    private static String teacherDelete = "DELETE FROM teacher t  WHERE t.idteacher = ?;";
    private static String studentDelete = "DELETE FROM student s  WHERE s.idstudent = ?;";

    //showing the relations
//    private static String showStudentsForThisTeacher ="SELECT student.idstudent,student.fname,student.lname from  student  JOIN teacherandstudent  on student.idStudent  = teacherandstudent.idStudent  " +
//            "JOIN teacher on  teacherandstudent.idTeacher = teacher.idTeacher  WHERE teacher.idTeacher = ?";

    private static String showStudentsForThisTeacher = "select s.fname,s.lname,s.idstudent from student s" +
            " join teacherAndStudent ts on s.idstudent = ts.idstudent" +
            " join teacher t on t.idteacher = ts.idteacher where t.idteacher = ?;";

    private static String showTeachersForThisStudent = "SELECT t.idteacher , t.fname , t.lname from  teacher t" +
            "   JOIN teacherandstudent  ts on t.idteacher = ts.idteacher  " +
            "JOIN student s on  ts.idstudent = s.idstudent  WHERE s.idstudent = ?;";
    public static String getTeacherLoad() {
        return teacherLoad;
    }

    public static String getShowStudentsForThisTeacher() {
        return showStudentsForThisTeacher;
    }

    public static String getShowTeachersForThisStudent() {
        return showTeachersForThisStudent;
    }

    public static String getStudentLoad() {
        return studentLoad;
    }

    public static String getTeacherAdd() {
        return teacherAdd;
    }

    public static String getStudentAdd() {
        return studentAdd;
    }

    public static String getTeacherUpdate() {
        return teacherUpdate;
    }

    public static String getStudentUpdate() {
        return studentUpdate;
    }

    public static String getTeacherDelete() {
        return teacherDelete;
    }

    public static String getStudentDelete() {
        return studentDelete;
    }
}
