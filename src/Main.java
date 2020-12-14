import entities.Person;
import entities.Student;
import entities.Teacher;
import service.Services;
import userData.aa.StudentSevice;
import userData.aa.TeacherService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        Student student = new Student();
        TeacherService teacherService = new TeacherService();
        StudentSevice studentSevice = new StudentSevice();
        Services services = new Services();
        while (true) {
        int selection = menu();
            switch (selection) {
                case 1:
                    showTheList(services.showAll(selection));
                    break;
                case 2:
                    showTheList(services.showAll(selection));
                    break;
                case 3:
                    services.add(newPerson(teacher));
                    break;
                case 4:
                    services.add(newPerson(student));
                    break;
                case 5:
                    System.out.println("Enter info of the Teacher that you want to update :");
                    services.update(newPerson(teacher));
                    break;
                case 6:
                    System.out.println("Enter ID of the Student that you want to update :");
                    services.update(newPerson(student));
                    break;
                case 7:
                    System.out.println("Enter ID of the Teacher that you want to delete :");
                    services.delete(scanInteger());
                    break;
                case 8:
                    System.out.println("Enter ID of the Student that you want to delete :");
                    services.delete(scanInteger());
                    break;
                case 9:
                    System.out.println("Enter ID of the Student that you want to see its teachers :");
                    showTheList(services.showTheRelationsOfthisPerson(scanInteger()));
                    break;
                case 10:
                    System.out.println("Enter ID of the Teacher that you want to see its students :");
                        showTheList(services.showTheRelationsOfthisPerson(scanInteger()));
                    break;
                default:
                    System.out.println("You only can select between 1 - 6 !");
                    break;

            }
        }


//        teacherService.update(new Teacher(21,"eisa","moloodr"));

//       /List<Student> t = teacherService.showStudentsForThisTeacher(22);
//                List<Teacher> l = teacherService.showAll();
//
//        for(Student s : t){
//            System.out.println(s);
//        }
//                for (Teacher e : l) {
//                    System.out.println(e);
//                }
        }

//    private static Teacher newTeacher() {
//        Scanner scanner = new Scanner(System.in);
//        Teacher teacher = new Teacher();
//        System.out.println("Enter the id Of  Teacher :");
//        teacher.setId(scanInteger());
//        System.out.println("Enter the first name Of  Teacher :");
//        teacher.setFname(scanner.next());
//        System.out.println("Enter the Last name Of  Teacher :");
//        teacher.setLname(scanner.next());
//        return teacher;
//    }

    private static <T extends Person>  T newPerson(T t) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First name:");
        t.setFname(scanner.next());
        System.out.println("Enter the Last name:");
        t.setLname(scanner.next());
        System.out.println("Enter the ID:");
        t.setId(scanInteger());
        return t;
    }

    private static <T> void showTheList(List<T> list){
        if (list != null) {
            for (T e : list) {
                System.out.println(e);
            }
        }
    }

//    private static <T extends Teacher> T newPerson() {
//        Scanner scanner = new Scanner(System.in);
//        T t = null;
//        System.out.println("Enter the FirstName Of new person :");
//        t.setFname(scanner.next());
//        System.out.println("Enter the LastName Of new person :");
//        t.setLname(scanner.next());
//        System.out.println("Enter the Id Of new person :");
//        t.setTeacherId(scanner.nextInt());
//        return t;
//    }

    private static int menu () {
            System.out.println('\n'+"Welcome ! Please select one of these :");
            System.out.println("1. Show all Teachers.");
            System.out.println("2. Show all Students.");
            System.out.println("3. Add new Teacher.");
            System.out.println("4. Add new Student.");
            System.out.println("5. Update new Teacher.");
            System.out.println("6. Update new Student.");
            System.out.println("7. Delete a Teacher.");
            System.out.println("8. Delete a Student.");
            System.out.println("9. Show the teachers for this student(Enter id of the student).");
            System.out.println("10. Show the students for this teacher(Enter id of the teacher).");

            return scanInteger();
        }

        public static int scanInteger(){
            Scanner scanner = new Scanner(System.in);
            int s = 0;
            try {
                s = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Please Enter number!");
            }
            return s;
        }



    }

