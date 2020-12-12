package com.commercialeater.models;

import com.commercialeater.database.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction {

    public static final String TABLE            = "transactions";
    public static final String ID               = "id";
    public static final String USER_FR          = "userId";
    public static final String AMOUNT           = "amount";
    public static final String TRANSACTION_DATE = "dateTime";
    public static final String TRANSACTION_TYPE = "transactionType";

    public static final String USER_CONCAT = "user";

    public static ResultSet getAll() {

        ResultSet result = null;
        String query = "SELECT "+ TRANSACTION_DATE + ", "+ TRANSACTION_TYPE +
                ", CONCAT("+ User.FIRST_NAME +", \" \","+ User.LAST_NAME +") as user " +
                "FROM "+ TABLE +", "+ User.TABLE +
                " WHERE "+ TABLE +"."+ USER_FR +" = "+ User.TABLE +"."+ User.ID +
                " ORDER BY DATE(" + TRANSACTION_DATE +") DESC";

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query);
            result = stm.executeQuery();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }

    public static ResultSet getQueryData(String startDate, String endDate, String user, String transType) {

        ResultSet result = null;
        String date = null;
        StringBuilder query = new StringBuilder("SELECT "+ TRANSACTION_DATE + ", "+ TRANSACTION_TYPE +
                ", CONCAT("+ User.FIRST_NAME +", \" \","+ User.LAST_NAME +") as user " +
                " FROM " + TABLE +", "+ User.TABLE + " WHERE ");

        if (startDate != null && endDate != null) {
            query.append(TRANSACTION_DATE +" BETWEEN ? AND ? AND");
            date = "Between";
        }
        else if (endDate != null) {
            query.append(TRANSACTION_DATE +" <= ? AND");
            date = endDate;
        }
        else if (startDate != null) {
            query.append(TRANSACTION_DATE +" >= ? AND");
            date = startDate;
        }

        query.append("(" + User.FIRST_NAME +" LIKE ? OR " +
                User.LAST_NAME +" LIKE ? OR " +
                User.EMAIL +" LIKE ?) AND " +
                TRANSACTION_TYPE +" LIKE ? ");

        if (user.equals("") || user.toLowerCase().equals("all")) {
            user = "";
        }

        if (transType.toLowerCase().equals("all")) {
            transType = "%";
        }

        query.append("AND "+ TABLE +"."+ USER_FR +" = "+ User.TABLE +"."+ User.ID +" ");
        query.append("ORDER BY DATE(" + TRANSACTION_DATE +") DESC ");

        try {
            PreparedStatement stm = DatabaseConnector.getDatabaseConn().prepareStatement(query.toString());
            int pos = 1;

            if (date != null) {
                if (date.equals("Between")) {
                    stm.setString(pos++, startDate);
                    stm.setString(pos++, endDate);
                }
                else {
                    stm.setString(pos++, date);
                }
            }

            stm.setString(pos++, "%" + user + "%");
            stm.setString(pos++, "%" + user + "%");
            stm.setString(pos++, "%" + user + "%");
            stm.setString(pos, transType);

            result = stm.executeQuery();

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return result;
    }
}
