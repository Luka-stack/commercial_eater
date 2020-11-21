package com.commercialeater.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {

    private static DatabaseConnector databaseLink;

    private Connection conn;

    private DatabaseConnector() {
        try {

            DatabaseConfig dbConfig = new DatabaseConfig();

            conn = DriverManager.getConnection(
                    dbConfig.getDbUrl(), dbConfig.getDbUsername(), dbConfig.getDbPassword()
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getDatabaseConn() {

        if (databaseLink == null) {
            databaseLink = new DatabaseConnector();
        }

        return databaseLink.conn;
    }

}
