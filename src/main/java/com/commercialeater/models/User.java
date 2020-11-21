package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;
import com.commercialeater.database.DatabaseConstants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    public static boolean checkUserExistence(String username, String password) {

        boolean result = false;

        String query = "SELECT 1 FROM " + DatabaseConstants.USER_TABLE + " WHERE "
                + DatabaseConstants.USER_USERNAME + " = ? AND "
                + DatabaseConstants.USER_PASSWORD + " = ?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            result = stm.executeQuery().next();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
