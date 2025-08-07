package com.tss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/quiz_app";
	private static final String USERNAME = "root"; 
	private static final String PASSWORD = "priyank@2k25"; 

	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
