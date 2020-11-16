package ru.demin.pract16_2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.demin.pract15_1.MyLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Main {
    public static final String url = "https://www.mirea.ru";

    public static void main(String[] args) {
        try {
            List<String> sources = getSources(url);
            ImagesLoader imagesLoader = new ImagesLoader(sources,"images");
            imagesLoader.downloadAllImages();
        } catch (IOException ex) {
            MyLogger.log(ex.getLocalizedMessage(), Level.WARNING);
        }
    }

    public static List<String> getSources(String url) throws IOException {
        ArrayList<String> sources = new ArrayList<>();

        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("img");
        elements.forEach(element -> {
            String src;
            if(!(src = element.attr("abs:src")).equals("")) {
                sources.add(src);
            }
        });

        return sources;
    }
}
