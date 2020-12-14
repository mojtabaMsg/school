package service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import connection.DbConnection;
import entities.Person;
import entities.Student;
import entities.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Services<T extends Person> {
    private String addQuery ;
    private String updateQuery ;
    private String selectQuery ;
    private String deleteQuery ;
    private String idField ;
    private String showingRelationsQuery;
    public void add(T t){
        typeDetection(t);
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(addQuery)){
            preparedStatement.setInt(1,t.getId());
            preparedStatement.setString(2,t.getFname());
            preparedStatement.setString(3,t.getLname());
            int check = preparedStatement.executeUpdate();
            if (check>0)
                System.out.println("This person added successfully");
            else
                System.out.println("This person didn't add !");
        } catch (MySQLIntegrityConstraintViolationException e){
            System.out.println("This ID exists !");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(T t){
        typeDetection(t);
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(updateQuery)){
            preparedStatement.setString(1,t.getFname());
            preparedStatement.setString(2,t.getLname());
            preparedStatement.setInt(3,t.getId());
            int check = preparedStatement.executeUpdate();
            if (check>0)
                System.out.println("Updated succsefully !");
            else
                System.out.println("This person deosn't exist !");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        if (id>=30){
            deleteQuery = Queries.getTeacherDelete();
        } else if (id>=10 && id<30){
            deleteQuery = Queries.getStudentDelete();
        }
        PreparedStatement preparedStatement2 = null;
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
            preparedStatement.setInt(1,id);
            int check1 = preparedStatement.executeUpdate();

            if(check1 != 0)
                System.out.println("Deleted successfully !");
            else
                System.out.println("This record not found !");

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement2 != null)
                    preparedStatement2.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public List<T> showAll(int teacherOrStudent) {
        if(teacherOrStudent == 1){
            selectQuery = Queries.getTeacherLoad();
            idField = "idteacher";
        }else{
            selectQuery = Queries.getStudentLoad();
            idField = "idStudent";
        }

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> tList = new ArrayList<>();
            while (resultSet.next()) {
                T t = (T) new Person();
                t.setId(resultSet.getInt(idField));
                t.setFname(resultSet.getString("fname"));
                t.setLname(resultSet.getString("lname"));
                tList.add(t);
            }
            if(!tList.isEmpty())
                return tList;
            else
                System.out.println("This person doesn't exist !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  List<T> showTheRelationsOfthisPerson(int id) {
        if (id>=30){
            showingRelationsQuery = Queries.getShowStudentsForThisTeacher();
            idField = "idstudent";
        } else if (id>=10 && id<30){
            showingRelationsQuery = Queries.getShowTeachersForThisStudent();
            idField = "idTeacher";
        }
        try (Connection connection = DbConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("select * from student join teacherandstudent on student.idstudent = teacherandstudent.idstudent join teacher on teacherandstudent.idteacher = teacher.idteacher where teacher.idteacher = ?");) {
             PreparedStatement preparedStatement = connection.prepareStatement(showingRelationsQuery);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> qList = new ArrayList<>();
            while (resultSet.next()) {
                T q = (T) new Person();
                q.setId(resultSet.getInt(idField));
                q.setFname(resultSet.getString("fname"));
                q.setLname(resultSet.getString("lname"));
                qList.add(q);
            }
            if (!qList.isEmpty())
                return qList;
            else
                System.out.println("Not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void typeDetection(T t){
        if (t instanceof Teacher){
            addQuery = Queries.getTeacherAdd();
            updateQuery = Queries.getTeacherUpdate();
            deleteQuery = Queries.getTeacherDelete();
            selectQuery = Queries.getTeacherLoad();
            idField = "idTeacher";
        } else if (t instanceof Student){
            addQuery = Queries.getStudentAdd();
            updateQuery = Queries.getStudentUpdate();
            deleteQuery = Queries.getStudentDelete();
            selectQuery = Queries.getStudentLoad();
            idField = "idStudent";
        }
    }
}
