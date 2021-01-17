package com.commercialeater.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_DB_URL_REGEX =
            Pattern.compile("[A-Z]+:[A-Z]+:\\/\\/[A-Z0-9.]+:[0-9]{1,5}\\/[A-Z0-9._]+", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_MONEY_REGEX = Pattern.compile("^[1-9]+[0-9]*[,.]?[0-9]*");

    private static final Pattern VALID_MONEY_FILTER_REGEX = Pattern.compile("[<=>]?\\d+(.\\d{1,2})?");

    private static final Pattern VALID_HEX_COLOR_REGEX = Pattern.compile("#[A-Z0-9]{6}", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_RGB_COLOR_REGEX =
            Pattern.compile("\\s*\\(?\\s*[0-9]{1,3}\\s*,\\s*[0-9]{1,3}\\s*,\\s*[0-9]{1,3}\\s*\\)?\\s*");

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validateDBUrl(String dbUrl) {
        Matcher matcher = VALID_DB_URL_REGEX.matcher(dbUrl);
        return matcher.find();
    }

    public static boolean validateRGBColor(String rgbColor) {
        Matcher matcher = VALID_RGB_COLOR_REGEX.matcher(rgbColor);
        return matcher.find();
    }

    public static boolean validateHEXColor(String hexColor) {
        Matcher matcher = VALID_HEX_COLOR_REGEX.matcher(hexColor);
        return matcher.find();
    }

    public static boolean validateMoneyFilter(String money) {
        Matcher matcher = VALID_MONEY_FILTER_REGEX.matcher(money);
        return matcher.find();
    }

    public static boolean validateMoney(String money) {
        Matcher matcher = VALID_MONEY_REGEX.matcher(money);
        return matcher.find();
    }
}
