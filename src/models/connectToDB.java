package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectToDB {
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:src/db/databaselite";
        Connection conn  = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            conn = null;
        }
        return conn;
    }
}
