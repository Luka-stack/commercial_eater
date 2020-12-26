package com.commercialeater.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

public class UIUtilities {

    private Color background;
    private Color mainColor;
    private Color mainTextColor;
    private Color buttonsColor;
    private Color buttonsHoverColor;
    private Color buttonsTextColor;

    // TMP Solution
    private final String stylePath = "D:\\New folder\\jv\\commercial_eater\\config\\app_style.json";

    public UIUtilities() {

        JSONParser jsonParser = new JSONParser();

        //try (FileReader reader = new FileReader("config/dbconfig.json")) {
        try (FileReader reader = new FileReader(stylePath)) { // TMP Solution

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            background = Color.decode((String) jsonObject.get("background"));
            mainColor = Color.decode( (String) jsonObject.get("main_color") );
            mainTextColor = Color.decode( (String) jsonObject.get("main_text_color") );
            buttonsColor = Color.decode( (String) jsonObject.get("buttons_color") );
            buttonsHoverColor = Color.decode( (String) jsonObject.get("buttons_hover_color") );
            buttonsTextColor = Color.decode( (String) jsonObject.get("buttons_text_color") );
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonHoverExited(JPanel panel) {
//        panel.setBackground(new Color(153, 194, 93));
        panel.setBackground(buttonsColor);
    }

    public void buttonHoverEntered(JPanel panel) {
//        panel.setBackground(new Color(125, 166, 63));
        panel.setBackground(buttonsHoverColor);
    }

    public Color getBackground() {
        return background;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public Color getMainTextColor() {
        return mainTextColor;
    }

    public Color getButtonsColor() {
        return buttonsColor;
    }

    public Color getButtonsHoverColor() {
        return buttonsHoverColor;
    }

    public Color getButtonsTextColor() {
        return buttonsTextColor;
    }

    public String getMainColorHEX() {
        return rgb2Hex(mainColor.getRed(), mainColor.getGreen(), mainColor.getBlue());
    }

    public String getMainTextColorHEX() {
        return rgb2Hex(mainTextColor.getRed(), mainTextColor.getGreen(), mainTextColor.getBlue());
    }

    public String getButtonsColorHEX() {
        return rgb2Hex(buttonsColor.getRed(), buttonsColor.getGreen(), buttonsColor.getBlue());
    }

    public String getButtonsTextColorHEX() {
        return rgb2Hex(buttonsTextColor.getRed(), buttonsTextColor.getGreen(), buttonsTextColor.getBlue());
    }

    private String rgb2Hex(int red, int green, int blue) {
        return String.format("#%02x%02x%02x", red, green, blue);
    }
}
