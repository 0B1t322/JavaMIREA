package ru.demin.pract13_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static final String PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
