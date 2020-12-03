package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    public static final String TABLE      = "users";
    public static final String ID         = "id";
    public static final String EMAIL      = "email";
    public static final String PASSWORD   = "password";
    public static final String ROLE       = "role";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME  = "lastName";
    public static final String CITY       = "city";

    public static boolean checkExistence(String email, String password) {

        boolean result = false;

        String query = "SELECT 1 FROM " + TABLE + " WHERE "
                + EMAIL + " = ? AND "
                + PASSWORD + " = ?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, email);
            stm.setString(2, password);
            result = stm.executeQuery().next();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ResultSet getAll() {

        ResultSet result = null;
        String query = "SELECT * FROM " + TABLE;

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            result = stm.executeQuery();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }
}
