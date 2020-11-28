package ru.demin.pract18;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        final String srcPath = "images";
        final String destPath = "dst";

        File src = new File(srcPath);

        File[] files = src.listFiles();

        try {
            if(!Files.exists(Paths.get(destPath)))
            {
                Files.createDirectory(Paths.get(destPath));
            }

            ImageResize resize = new ImageResize(files, destPath);

            for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                new Thread(() -> {
                    try {
                        resize.resize();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }).start();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
