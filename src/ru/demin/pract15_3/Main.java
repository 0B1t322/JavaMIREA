package ru.demin.pract15_3;

import ru.demin.pract15_1.MyLogger;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        Main m = new Main();

        String curDir = scaner.next(); // dir that we copy
        MyLogger.log("your input: " + curDir, Level.INFO);
        String dirInto = scaner.next(); // into this dir
        MyLogger.log("your input: " + dirInto, Level.INFO);

        try {
            FilesCopy.copy(curDir, dirInto);
        } catch (IOException ex) {
            MyLogger.log(ex.toString(), Level.WARNING);
        }

        MyLogger.ShowLog();
    }
}
