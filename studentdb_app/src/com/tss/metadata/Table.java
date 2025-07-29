package com.tss.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	public static void showTableMetadata(Connection conn, String tableName) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 1");

		ResultSetMetaData meta = rs.getMetaData();
		int columnCount = meta.getColumnCount();

		System.out.println("\n--- Table Metadata for: " + tableName + " ---");
		System.out.println("Number of Columns: " + columnCount);
		System.out.printf("%-20s %-20s\n", "Column Name", "Data Type");
		System.out.println("-----------------------------------------");

		for (int i = 1; i <= columnCount; i++) {
			String colName = meta.getColumnName(i);
			String dataType = meta.getColumnTypeName(i);
			System.out.printf("%-20s %-20s\n", colName, dataType);
		}

		rs.close();
		stmt.close();
	}
}
