package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dish {

    public static final String TABLE = "dishes";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String TYPE = "dishType";
    public static final String DIET = "diet";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";
    public static final String RESTAURANT_FK = "restaurantId";

    public static ResultSet getAllByRestaurant(Long id) {

        ResultSet result = null;
        String query = "SELECT D."+ ID  +",D."+ NAME +",D."+ TYPE +",D."+ DIET +",D."+ PRICE +
                ",R."+ Restaurant.NAME +" AS "+ Restaurant.TABLE +" FROM "+ TABLE +" D"+ ","+ Restaurant.TABLE +" R " +
                "WHERE "+ RESTAURANT_FK +"=? AND "+ RESTAURANT_FK +"= R."+ Restaurant.ID;

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

    public static ResultSet getQueryData(Long restaurantId, String nameFilter, String typeFilter, String dietFilter,
                                         String priceFilter, double price) {

        ResultSet result = null;
        StringBuilder query = new StringBuilder("SELECT D."+ ID  +",D."+ NAME +",D."+ TYPE +",D."+ DIET +",D."+ PRICE +
                ",R."+ Restaurant.NAME +" AS "+ Restaurant.TABLE +" FROM "+ TABLE +" D"+ ","+ Restaurant.TABLE +" R " +
                "WHERE "+ RESTAURANT_FK +"=? AND "+ RESTAURANT_FK +"= R."+ Restaurant.ID + " AND " +
                "D."+ NAME +" LIKE ? AND "+ TYPE +" LIKE ? AND "+ "D."+ DIET +" LIKE ? ");

        if (priceFilter.equals(">")) {
            query.append("AND PRICE > ?");
        }
        else if (priceFilter.equals("<")) {
            query.append("AND PRICE < ?");
        }
        else if (priceFilter.equals("=")){
            query.append("AND PRICE = ?");
        }
        else {
            query.append("AND PRICE > ?");
            price = 0;
        }

        if (nameFilter.equals("") || nameFilter.toLowerCase().equals("all")) {
            nameFilter = "%";
        }

        if (typeFilter.equals("") || typeFilter.toLowerCase().equals("all")) {
            typeFilter = "%";
        }

        if (dietFilter.equals("") || dietFilter.toLowerCase().equals("all")) {
            dietFilter = "%";
        }

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query.toString());
            stm.setLong(1, restaurantId);
            stm.setString(2, nameFilter.toLowerCase() + "%");
            stm.setString(3, typeFilter);
            stm.setString(4, dietFilter);
            stm.setDouble(5, price);
            result = stm.executeQuery();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static ResultSet getById(Long id) {

        ResultSet result = null;

        String query = "SELECT * FROM " + TABLE + " WHERE "+ ID +"=?";

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
}
