package ru.demin.pract13_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChecker {
    static final String NAME_PATTERN =
            "^[a-zA-Zа-яА-я-\\s]*$";


    public static boolean ifName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    public static String ifNameString(String name) throws IllegalStateException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        matcher.matches();

        return matcher.group();
    }

    public static String ifNameStringFormated(String name) throws IllegalStateException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);

        matcher.matches();

        String _name = matcher.group();

        return _name.substring(0,1).toUpperCase() + _name.substring(1).toLowerCase(); // делает вид Abcd
    }
}
