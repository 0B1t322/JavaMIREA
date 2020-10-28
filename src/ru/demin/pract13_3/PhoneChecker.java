package ru.demin.pract13_3;

import ru.demin.pract12.task_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneChecker {

    static final String PHONE_PATTERN =
            "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";


    // return true or false
    public static boolean ifPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }



    /**
    * if number matches return him - else throw
    * @return Phone number
    * @throws IllegalStateException
    */
    public static String ifPhoneNumberString(String phoneNumber) throws IllegalStateException {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);

        Matcher matcher = pattern.matcher(phoneNumber);

        matcher.matches();

        return matcher.group();
    }

    /**
     * if number matches return formatted number +7 (919) 965 64 74 - else throw
     * @return formatted phone number
     * @throws IllegalStateException
     */
    public static String ifPhoneNumberStringFormat(String number) throws IllegalStateException {
        String _number = ifPhoneNumberString(number);

        return task_3.getFormatedNubmer(_number);
    }
}

