package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public static final String BALANCE    = "balance";

    public static boolean validateLogin(String email, String password) {

         boolean result = false;

        String query = "SELECT "+ PASSWORD +" FROM " + TABLE + " WHERE "
                + EMAIL + " = ?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, email);

            ResultSet record = stm.executeQuery();

            if (record.next()) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                result = encoder.matches(password, record.getString(PASSWORD));
            }
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

    public static ResultSet getById(Long id) {

        ResultSet result = null;
        String query = "SELECT * FROM " + TABLE + " WHERE id = ?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setLong(1, id);
            result = stm.executeQuery();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static ResultSet getQueryData(String emailFilter, String firstNameFilter, String lastNameFilter,
                                         String cityFilter, String roleFilter) {

        ResultSet result = null;

        String query = "SELECT * FROM " + TABLE + " WHERE "+
                EMAIL +" LIKE ? AND "+ ROLE +" LIKE ? AND " +
                FIRST_NAME +" LIKE ? AND "+ LAST_NAME +" LIKE ? AND "+ CITY +" LIKE ?";

        if (emailFilter.equals("") || emailFilter.toLowerCase().equals("all")) {
            emailFilter = "%";
        }

        if (firstNameFilter.equals("") || firstNameFilter.toLowerCase().equals("all")) {
            firstNameFilter = "%";
        }

        if (lastNameFilter.equals("") || lastNameFilter.toLowerCase().equals("all")) {
            lastNameFilter = "%";
        }

        if (cityFilter.equals("") || cityFilter.toLowerCase().equals("all")) {
            cityFilter = "%";
        }

        if (roleFilter.toLowerCase().equals("all")) {
            roleFilter = "%";
        }

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, emailFilter.toLowerCase() + "%");
            stm.setString(2, roleFilter);
            stm.setString(3, firstNameFilter + "%");
            stm.setString(4, lastNameFilter + "%");
            stm.setString(5, cityFilter + "%");
            result = stm.executeQuery();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static int create(String email, String password, String role, String firstName, String lastName,
                             String city, double balance)
    {
        int result = 0;
        String query = "INSERT INTO " + TABLE + "("+
                EMAIL +", "+ PASSWORD +", "+ ROLE +", "+ FIRST_NAME +", "+ LAST_NAME +", "+ CITY +", "+ BALANCE +
                ") VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, email.toLowerCase());
            stm.setString(2, password);
            stm.setString(3, role.toLowerCase());
            stm.setString(4, firstName.toLowerCase());
            stm.setString(5, lastName.toLowerCase());
            stm.setString(6, city.toLowerCase());
            stm.setDouble(7, balance);
            result = stm.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static int update(Long id, String email, String password, String role, String firstName, String lastName,
                             String city, double balance)
    {
        int result = 0;
        String query = "UPDATE " + TABLE + " SET "+
                EMAIL +"=?, "+ PASSWORD +"=?, "+ ROLE +"=?, "+ FIRST_NAME +"=?, "+
                LAST_NAME +"=?, "+ CITY +"=?, "+ BALANCE + "=? WHERE "+ ID +"=?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, email.toLowerCase());
            stm.setString(2, password);
            stm.setString(3, role.toLowerCase());
            stm.setString(4, firstName.toLowerCase());
            stm.setString(5, lastName.toLowerCase());
            stm.setString(6, city.toLowerCase());
            stm.setDouble(7, balance);
            stm.setLong(8, id);
            result = stm.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static int delete(Long id) {

        int result = 0;
        String query = "DELETE FROM "+ TABLE +" WHERE "+ ID +"=?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setLong(1, id);
            result = stm.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }
}
