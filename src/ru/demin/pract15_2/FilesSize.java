package ru.demin.pract15_2;

import ru.demin.pract15_1.MyLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.logging.Level;

public class FilesSize {
    private File dir;


    public FilesSize(String path) throws IOException {
        File folder = new File(path);
        if(folder.exists()) {
            if (!folder.isDirectory()) {
                throw new IOException("Given file is not a directory");
            }

        } else {
            throw new IOException(path + " given file is not exsist");
        }

        this.dir = folder;
    }

    public long getSizeOfFiles() {
        long sizeOfFiles = 0;
        File[] files = dir.listFiles();
        if(files == null) { // if dir is empty
            return 0;
        }
        for(var file : files) {
            sizeOfFiles += _getSizeOfFile(file);
        }
        return sizeOfFiles;
    }

    private long _getSizeOfFiles(File dir) {
        long sizeOfFiles = 0;
        File[] files = dir.listFiles();
        for(var file : files) {
            sizeOfFiles += _getSizeOfFile(file);
        }
        return sizeOfFiles;
    }

    private long _getSizeOfFile(File file) {
        if(file.isFile()) {
            return file.length();
        }

        return _getSizeOfFiles(file);
    }

    public static String formatSize(long size) {
        final long Kb =      1024;
        final long Mb = Kb * 1024;
        final long Gb = Mb * 1024;
        final long Tb = Gb * 1024;

        if (size <  Kb)   return Form(           size     ) +  " Б";
        if (size < Mb)    return Form((double)size / Kb) + " Кб";
        if (size < Gb)    return Form((double)size / Mb) + " Мб";
        if (size < Tb)    return Form((double)size / Gb) + " Гб";

        return Form((double)size / Tb) + " Тб"; // if(size > Tb)
    }

    private static String Form (double d)
    {
        return new DecimalFormat("#.##").format(d);
    }
}
