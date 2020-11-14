package ru.demin.pract15_1;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
//        example usage
        Main m = new Main();
        MyLogger.log("Hello",Level.INFO);
        MyLogger.log("HELLO", Level.INFO);
        MyLogger.log("TEST", Level.WARNING);

        MyLogger.ShowLog();
    }
}
