package ru.demin.pract13_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneChecker {

    static final String PHONE_PATTERN =
            "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    // if phonenumber is correct return him - else trow excaption
    static boolean ifPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    static String ifPhoneNumberString(String phoneNumber) throws IllegalStateException {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);

        Matcher matcher = pattern.matcher(phoneNumber);

        matcher.matches();

        return matcher.group();
    }

    //TODO метод который возвращает отформатрованное имя
}

