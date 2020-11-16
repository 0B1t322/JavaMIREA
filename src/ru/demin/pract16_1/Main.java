package ru.demin.pract16_1;

import ru.demin.pract15_1.MyLogger;


import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final String path_to_csv = "data/movementList.csv";

        CsvWorker csvWorker = new CsvWorker(
                ParseCsv.Parse(path_to_csv, ",")
        );

        // Считаем расходы -------------------------
        System.out.println(
                getAllExpenses(
                    csvWorker.getCol("Расход")
                )
        );
        // ----------------------------------------
        // Считаем доходы -------------------------
        System.out.println(
                getAllRevue(
                        csvWorker.getCol("Приход")
                )
        );
        // ----------------------------------------
        // Разбиение расходов по компаниям
        List<String> listOfComp = formatCompanies(
                csvWorker.getCol("Описание операции")
        );

        Map<String, Double> map = getAllComp(listOfComp);

        sumExpansesEachCompany(map, listOfComp, csvWorker.getCol("Расход"));

        System.out.println("Суммы расходов по организациям:");
        map.entrySet().stream().forEach(new Consumer<>() {
            @Override
            public void accept(Map.Entry<String, Double> stringDoubleEntry) {
                Formatter formatter = new Formatter();

                formatter.format("%s\t\t%.2f Руб.",
                        stringDoubleEntry.getKey(), stringDoubleEntry.getValue()
                );

                System.out.println(formatter.toString());
            }
        });

    }

    public static double Sum(List<String> list) { // считает все числа переданные в листе
        return
                list.stream()
                        .mapToDouble(element -> Double.parseDouble(
                                element.replaceAll("[^0-9]", "")
                        ))
                        .sum();
    }

    public static String getAllExpenses(List<String> expenses) { // возвращает отформатированную строку суммы
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

    // функции для разбиения расходов

    // Создадим словарь из всех компаний которые встречаются в файле
    public static Map<String, Double> getAllComp(List<String> companies) {
        HashMap<String, Double> _companies = new HashMap<>();
        for(var companie: companies) {
            _companies.put(companie, (double) 0);
        }

        return  _companies;
    }

    public static List<String> formatCompanies(List<String> companies) {
        ArrayList<String> list = new ArrayList<>();
        final String regex = "(\\\\.*\\\\[a-zA-Z0-9_>]*(\\s[a-zA-Z0-9]*){1,4})|(\\/.*\\/[a-zA-Z0-9]*(\\s[a-zA-Z0-9_>]*){1,4})";
        final Pattern pattern = Pattern.compile(regex);

        for(var companie: companies) {
            Matcher matcher = pattern.matcher(companie);
            if(matcher.find()) {
                String formattedCompanie = matcher.group(0);
                formattedCompanie = formattedCompanie
                                    .replace("\\","")
                                    .replace("/","");
                list.add(formattedCompanie);
            }
        }

        return list;
    }

    public static void sumExpansesEachCompany(
            Map<String, Double> map,
            List<String> companies,
            List<String> expanses
    ) {
        for(int i = 0; i < companies.size(); i++) {
            map.put(
                    companies.get(i),
                    map.get(companies.get(i)) + Double.parseDouble(
                            expanses.get(i)
                                    .replaceAll("[^0-9]", "")
                    )
            );
        }
    }

}


