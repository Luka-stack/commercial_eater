package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Restaurant {

    public static final String TABLE       = "restaurants";
    public static final String ID          = "id";
    public static final String NAME        = "name";
    public static final String ADDRESS     = "address";
    public static final String DESCRIPTION = "description";

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

    public static ResultSet getQueryData(String nameFiler, String addressFilter) {

        ResultSet result = null;

        String query = "SELECT * FROM " + TABLE + " WHERE name LIKE ? AND address LIKE ?";

        if (nameFiler.equals("") || nameFiler.toLowerCase().equals("all")) {
            nameFiler = "%";
        }

        if (addressFilter.equals("") || addressFilter.toLowerCase().equals("all")) {
            addressFilter = "%";
        }

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, nameFiler.toLowerCase() + "%");
            stm.setString(2, addressFilter.toLowerCase() + "%");
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

    // TODO capitalize?
    public static int create(String name, String address, String description) {

        int result = 0;
        String query = "INSERT INTO " + TABLE + "("+ NAME +", "+ ADDRESS +", "+ DESCRIPTION +") VALUES (?, ?, ?)";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, address);
            stm.setString(3, description);
            result = stm.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static int update(Long id, String name, String address, String description) {

        int result = 0;
        String query = "UPDATE "+ TABLE +" SET "+ NAME +"=?, " + ADDRESS +"=?, "+ DESCRIPTION +"=? WHERE "+ ID +"=?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, address);
            stm.setString(3, description);
            stm.setLong(4, id);
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
