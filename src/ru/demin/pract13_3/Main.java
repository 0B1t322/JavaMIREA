package ru.demin.pract13_3;

import javax.naming.Name;
import java.util.Scanner;

public class Main {
    public static void check(String input) {

    }

    public static void main(String[] args) {
        PhoneMap phoneMap = new PhoneMap();
        Scanner scanner = new Scanner(System.in);


        String phoneNumber = "";
        String name = "";

        for(;;) {
            String input = scanner.nextLine();

            if(input.equals("")) continue;

            if(PhoneChecker.ifPhoneNumber(input)) {
                phoneNumber = PhoneChecker.ifPhoneNumberStringFormat(input);

                if(phoneMap.checkIsExsistPhoneNumber(phoneNumber)) { // если такой номер телефона существует вывести его
                    phoneMap.printInfo(phoneNumber);
                    continue;
                }

                System.out.println("Введите имя: ");

                input = scanner.next();

                if(NameChecker.ifName(input)) {
                    name = NameChecker.ifNameStringFormated(input);

                    phoneMap.addWrite(phoneNumber, name);
                } else {
                    System.out.println("Вы написали неверный формат имени");
                    continue;
                }
            } else if(NameChecker.ifName(input) && !phoneMap.ifCommandExsist(input)) {
                name = NameChecker.ifNameStringFormated(input);

                if(phoneMap.checkIfExistName(name)) {
                    phoneMap.printInfoByName(name);
                    continue;
                }

                System.out.println("Введите номер телефона: ");
                input = scanner.nextLine();

                if(PhoneChecker.ifPhoneNumber(input)) {
                    phoneNumber = PhoneChecker.ifPhoneNumberStringFormat(input);

                    phoneMap.addWrite(phoneNumber, name);
                } else {
                    System.out.println("Вы написали неверный формат номера");
                    continue;
                }
            } else {

                phoneMap.ReadCommand(input,new String[]{});
            }
        }
    }
}
