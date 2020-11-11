package ru.demin.pract15_2;

import ru.demin.pract15_1.MyLogger;

import java.io.IOException;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        if(args.length != 1) {
            MyLogger.log(m, "Require 1 arg - path to directory");
        }

        String path = args[0];

        FilesSize fs;

        try {
            fs = new FilesSize(path);
        } catch (IOException ex) {
            MyLogger.log(m,ex.toString(), Level.WARNING);
            return;
        }
        long size = fs.getSizeOfFiles();

        System.out.println("Размер папки " + path + " " + FilesSize.formatSize(size));
    }
}
