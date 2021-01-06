package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class City {

    public final static String TABLE = "cities";
    public final static String ID = "id";
    public final static String NAME = "name";

    public static List<String> getCitiesArray() {

        List<String> result = new ArrayList<>();
        ResultSet cities = getAll();

        try {
                while (cities.next()) {

                    result.add(cities.getString(NAME));
                }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static ResultSet getAll() {

        ResultSet result = null;
        String query = "SELECT * FROM "+ TABLE;

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            result = stm.executeQuery();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static int create(String name) {

        int result = 0;
        String query = "INSERT INTO "+ TABLE +" WHERE "+ NAME +"=?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(1, name);
            result = stm.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static int delete(String name) {

        int result = 0;
        String query = "DELETE FROM "+ TABLE +" WHERE "+ NAME +"=?";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            stm.setString(0, name);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }
}
