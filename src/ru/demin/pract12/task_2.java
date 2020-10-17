package ru.demin.pract12;

import java.util.Arrays;
import java.util.Scanner;

class FullName {
    public String firstName;
    public String secondName;

    public FullName() {

    }

    public FullName(String secondName, String firstName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Фамилия: " + secondName +
                "\nИмя: " + firstName;
    }
}

class FullNameAndFathers extends FullName {
    public String fathersName;

    public FullNameAndFathers() {

    }

    public FullNameAndFathers(String secondName, String firstName, String fathersName) {
        super(secondName, firstName);
        this.fathersName = fathersName;
    }

    @Override
    public String toString() {
        return "Фамилия: " + secondName +
                "\nИмя: " + firstName +
                "\nОтчество: " + fathersName;
    }

}

public class task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        FullName fullName;

        switch (words.length) {
            case 2:
                fullName = new FullName(words[0], words[1]);
                System.out.println(fullName);
                break;
            case 3:
                fullName = new FullNameAndFathers(words[0], words[1], words[2]);
                System.out.println(fullName);
                break;
            default:
                System.out.println("Введенная строка не соотвествует ФИО");
                return;
        }
    }
}
