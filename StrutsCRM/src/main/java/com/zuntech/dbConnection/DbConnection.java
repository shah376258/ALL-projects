package com.zuntech.dbConnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;

    private DbConnection() {
        // Private constructor to prevent instantiation from outside
    }

    public static Connection getConnection() {
        if (con == null) {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root",  "Shah@123");
                System.out.println("Connection established");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}

