package ru.demin.pract13_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChecker {
    static final String NAME_PATTERN =
            "^[a-zA-Zа-яА-я-\\s]*$";


    public static String ifNameString(String name) throws IllegalStateException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        matcher.matches();

        return matcher.group();
    }
    //TODO метод который проверяет и возвращает отформатированное имя
}
