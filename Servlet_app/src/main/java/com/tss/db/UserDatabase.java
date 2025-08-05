package com.tss.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDatabase {

	private static Connection connection;

	public static Connection connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			if (connection == null)
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "priyank@2k25");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
}
