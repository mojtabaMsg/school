package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String url="jdbc:mysql://localhost/schoool?autoReconnect=true&useSSL=false";
    private final static String username="root";
    private final static String password="qazwsxedcrfvtgbyhnujmik,";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}


