package com.tss.creational.singleton.model;

public class DatabaseConnection {

	private static DatabaseConnection connection = null;

	private DatabaseConnection() {

	}

	public static DatabaseConnection DBConnection() {
		if (connection == null)
			connection = new DatabaseConnection();
		return connection;
	}
}
