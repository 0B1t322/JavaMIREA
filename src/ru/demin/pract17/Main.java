package ru.demin.pract17;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    final static String path_to_file = "data/moscowSubway.json";

    public static void main(String[] args) {
        writeJsonFile();
        System.out.println(countStationFromJson());
    }

    public static void writeJsonFile() {
        try {
            createFile(path_to_file);

            MoscowSubway moscowSubway = parseWebSite("https://www.moscowmap.ru/metro.html#lines");

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(MoscowSubway.class, new MoscowSubwayConvertor())
                    .setPrettyPrinting()
                    .create();

            FileWriter fileWriter = new FileWriter(path_to_file,false);
            String json = gson.toJson(moscowSubway);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int countStationFromJson() {
        int countOfStation = 0;
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(MoscowSubway.class, new MoscowSubwayConvertor())
                    .create();
            FileReader jsonFile = new FileReader(path_to_file);
            MoscowSubway moscowSubway = gson.fromJson(jsonFile, MoscowSubway.class);

            countOfStation = moscowSubway
                    .getStations()
                    .getStations()
                    .values()
                    .stream()
                    .mapToInt(List::size)
                    .sum();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return countOfStation;
    }

    public static MoscowSubway parseWebSite(String url) throws IOException {
        MoscowSubway moscowSubway = new MoscowSubway();
        Document document = Jsoup.connect(url).maxBodySize(0).get();

        Elements listOfLinesAndStation = document.select("div[class=content-wrapper]");
        Elements lines = listOfLinesAndStation.select("span[data-line~=[0-9]]");
        lines.forEach(line -> {
            String lineNumber = line.attr("data-line");
            String lineName = line.text();
            moscowSubway.getLines().add(new Line(lineNumber, lineName));
        });

        Elements stations = listOfLinesAndStation.select("div[data-line~=[0-9]]");
        stations.forEach( station -> {
            String lineNumber = station.attr("data-line");
            Elements stationName = station.select("div[data-line="+lineNumber+"]").select("span[class=name]");
            stationName.forEach(name -> {
                moscowSubway.getStations().put(lineNumber, name.text());
            });
        });

        return moscowSubway;
    }

    public static void createFile(String path) throws IOException {
        File file = new File(path);

        file.createNewFile();

    }
}


