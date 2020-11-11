package ru.demin.pract15_1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyLogger {
    private static void createDirAndFileIfNoExsist() {
        String path = MyLogger.class.getProtectionDomain().getCodeSource().
                getLocation().getPath();

        path = path.substring(0, path.indexOf("out/"));
        File tmpDir = new File(path + "tmp");

        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }


    }

    public static void log(Object from, String msg, Level level) {
        createDirAndFileIfNoExsist();

        Logger logger = Logger.getLogger(from.getClass().getName());
        try {
            LogManager.getLogManager().
                    readConfiguration(MyLogger.class.
                            getResourceAsStream("logging.properties")
                    );
        } catch (IOException ex) {
            System.err.println("Could not setup logger configuration: " + ex.toString());
        }
        logger.log(level, msg);
    }

    public static void log(Object from, String msg) {
        createDirAndFileIfNoExsist();

        Logger logger = Logger.getLogger(from.getClass().getName());
        try {
            LogManager.getLogManager().
                    readConfiguration(MyLogger.class.
                            getResourceAsStream("logging.properties")
                    );
        } catch (IOException ex) {
            System.err.println("Could not setup logger configuration: " + ex.toString());
        }
        logger.log(Level.INFO, msg);
    }

}
