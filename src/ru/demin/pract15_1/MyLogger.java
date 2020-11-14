package ru.demin.pract15_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyLogger {
    public static final String path_to_log = "tmp/log.txt";

    private static void createDirAndFileIfNoExsist() {
        String path = MyLogger.class.getProtectionDomain().getCodeSource().
                getLocation().getPath();

        path = path.substring(0, path.indexOf("out/"));
        File tmpDir = new File(path + "tmp");

        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }


    }

    public static void log(String msg, Level level) {
        createDirAndFileIfNoExsist();
        writeToFile(msg, level);
    }

    public static void ShowLog() {
        StringBuffer buffer = new StringBuffer();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path_to_log));

            for(String line : lines) {
                buffer.append(line + "\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println(buffer);
    }

    private static void writeToFile(String msg, Level level) {
        Date time = new Date();
        String _msg = time.toString() + " " + level.getName() + ": "+ msg;
        try {
            ArrayList<String> list = new ArrayList<>();
            list.add(_msg);
            Files.write(Paths.get(path_to_log), list, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
