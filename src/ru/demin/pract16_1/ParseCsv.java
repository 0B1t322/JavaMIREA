package ru.demin.pract16_1;

import ru.demin.pract15_1.MyLogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class ParseCsv {
    public static List<String[]> Parse(final String path_to_csv, final String separator) {
        String line = "";
        ArrayList<String[]> table = new ArrayList<>();

        try {
            FileReader csvFile = new FileReader(path_to_csv);
            BufferedReader buff = new BufferedReader(csvFile);

            while((line = buff.readLine()) != null) {
                String[] row = line.split(separator);

                table.add(row);
            }
            buff.close();
            csvFile.close();

        } catch (IOException ex) {
            MyLogger.log(ex.getMessage(), Level.WARNING);
        }

        return table;
    }
}
