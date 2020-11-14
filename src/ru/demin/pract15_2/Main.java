package ru.demin.pract15_2;

import ru.demin.pract15_1.MyLogger;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main m = new Main();

        String path = scanner.next();

        FilesSize fs;

        try {
            fs = new FilesSize(path);
        } catch (IOException ex) {
            MyLogger.log(ex.toString(), Level.WARNING);
            MyLogger.ShowLog();
            return;
        }
        long size = fs.getSizeOfFiles();

        MyLogger.log("Размер папки " + path + " " + FilesSize.formatSize(size), Level.INFO);
        MyLogger.ShowLog();

    }
}
