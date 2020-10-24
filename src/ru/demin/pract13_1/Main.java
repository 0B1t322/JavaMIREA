package ru.demin.pract13_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            String command = scanner.next();
            String[] CmdArgs = scanner.nextLine().trim().split("\\s+");

            if(CmdArgs.length == 1 && CmdArgs[0].equals("")) { // костыль
                CmdArgs = new String[0];
            }
            toDoList.ReadCommand(command, CmdArgs);
        }
    }
}
