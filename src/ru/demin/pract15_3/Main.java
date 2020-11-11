package ru.demin.pract15_3;

import ru.demin.pract15_1.MyLogger;

import java.io.IOException;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        if(args.length != 2) {
            MyLogger.log(m, "Require to args: [path] copy into [path]", Level.WARNING);
            return;
        }

        String curDir = args[0]; // dir that we copy
        String dirInto = args[1]; // into this dir

        try {
            FilesCopy.copy(curDir, dirInto);
        } catch (IOException ex) {
            MyLogger.log(m, ex.toString(), Level.WARNING);
        }
    }
}
