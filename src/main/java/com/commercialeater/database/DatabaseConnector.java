package com.commercialeater.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static DatabaseConnector databaseLink;

    private Connection conn;

    private DatabaseConnector() {
        try {

            DatabaseConfig dbConfig = new DatabaseConfig();

            this.conn = DriverManager.getConnection(
                    dbConfig.getDbUrl(), dbConfig.getDbUsername(), dbConfig.getDbPassword()
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnector getDatabaseLink() {

        if (databaseLink == null) {
            databaseLink = new DatabaseConnector();
        }

        return databaseLink;
    }
}
