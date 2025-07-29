package com.tss.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public static void showDatabaseMetadata(Connection conn) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        String dbName = conn.getCatalog(); 

        System.out.println("\n--- Database Metadata ---");
        System.out.println("Driver Name   : " + meta.getDriverName());
        System.out.println("Driver Version: " + meta.getDriverVersion());
        System.out.println("Database Name : " + dbName);

        System.out.println("Tables in the database:");
        ResultSet tables = meta.getTables(dbName, null, "%", new String[]{"TABLE"});
        while (tables.next()) {
            System.out.println(" - " + tables.getString("TABLE_NAME"));
        }
    }
}
