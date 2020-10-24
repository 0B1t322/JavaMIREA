package ru.demin.pract13_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);

        for(;;) {
            String command = scanner.next();
            String[] CmdArgs = scanner.nextLine().trim().split("\\s+");
            if(CmdArgs.length == 1 && CmdArgs[0].equals("")) { // костыль
                CmdArgs = new String[0];
            }

            emailList.ReadCommand(command, CmdArgs);
        }
    }
}
