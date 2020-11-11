package ru.demin.pract15_1;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
//        example usage
        Main m = new Main();
        MyLogger.log(m,"22");
        MyLogger.log(m,"HELLO", Level.INFO);
        MyLogger.log(m, "TEST", Level.WARNING);
    }
}
