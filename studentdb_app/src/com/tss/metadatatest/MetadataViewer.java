package com.tss.metadatatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.tss.metadata.Database;
import com.tss.metadata.Table;

public class MetadataViewer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tss_students_db", "root",
				"priyank@2k25")) {
			while (true) {
				System.out.println("\n=== Metadata Menu ===");
				System.out.println("1. Metadata of Database");
				System.out.println("2. Metadata of Table");
				System.out.println("3. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					Database.showDatabaseMetadata(conn);
					break;
				case 2:
					System.out.print("Enter table name: ");
					String tableName = scanner.nextLine();
					Table.showTableMetadata(conn, tableName);
					break;
				case 3:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
