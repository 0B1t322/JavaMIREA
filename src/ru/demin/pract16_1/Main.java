package ru.demin.pract16_1;

import ru.demin.pract15_1.MyLogger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        final String path_to_csv = "data/movementList.csv";

        CsvWorker csvWorker = new CsvWorker(
                ParseCsv.Parse(path_to_csv, ",")
        );

        // Считаем расходы ------------------------
        System.out.println(
                getAllExpenses(
                    csvWorker.getCol("Расход")
                )
        );
        // ----------------------------------------
        // Считаем доходы
        System.out.println(
                getAllRevue(
                        csvWorker.getCol("Приход")
                )
        );


    }

    public static double Sum(List<String> list) {
        return
                list.stream()
                        .mapToDouble(element -> Double.parseDouble(
                                element.replaceAll("[^0-9]", "")
                        ))
                        .sum();
    }

    public static String getAllExpenses(List<String> expenses) {
        double allExpenses = Sum(expenses);

        Formatter formatter = new Formatter();
        formatter.format("Сумма расходов: %.3f Руб", allExpenses);
        return formatter.toString();
    }

    public static String getAllRevue(List<String> revues) {
        double allRevues = Sum(revues);
        Formatter formatter = new Formatter();
        formatter.format("сумма доходов: %.3f Руб", allRevues);
        return formatter.toString();
    }


}
