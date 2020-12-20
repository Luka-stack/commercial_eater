package com.commercialeater.database;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseConfig {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    // TMP Solution
    private final String dbConfigPath = "D:\\New folder\\jv\\commercial_eater\\config\\dbconfig.json";

    public DatabaseConfig() {

        JSONParser jsonParser = new JSONParser();

        //try (FileReader reader = new FileReader("config/dbconfig.json")) {
        try (FileReader reader = new FileReader(dbConfigPath)) { // TMP Solution

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            dbUrl = (String) jsonObject.get("url");
            dbUsername = (String) jsonObject.get("username");
            dbPassword = (String) jsonObject.get("password");
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void saveConfig(String dbUrl, String dbUsername, String dbPassword) {

        try (FileWriter writer = new FileWriter(dbConfigPath)) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("url", dbUrl);
            jsonObject.put("username", dbUsername);
            jsonObject.put("password", dbPassword);

            writer.write(jsonObject.toJSONString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
