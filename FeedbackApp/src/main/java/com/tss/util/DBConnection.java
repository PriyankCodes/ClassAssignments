package com.tss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	
    private static final String URL = "jdbc:mysql://localhost:3306/feedback_app";
    private static final String USER = "root"; 
    private static final String PASSWORD = "priyank@2k25"; 

    public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
