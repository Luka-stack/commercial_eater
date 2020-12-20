package com.commercialeater.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_DB_URL_REGEX =
            Pattern.compile("[A-Z]+:[A-Z]+:\\/\\/[A-Z0-9.]+:[0-9]{1,5}\\/[A-Z0-9._]+", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validateDBUrl(String dbUrl) {
        Matcher matcher = VALID_DB_URL_REGEX.matcher(dbUrl);
        return matcher.find();
    }

}
