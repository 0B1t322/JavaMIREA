package ru.demin.pract14;

import java.util.ArrayList;
import java.util.Random;

public class BeatifulCarNumber {
    final String[] words = new String[] {"А", "В", "Е", "К", "М", "Н", "О", "Р","С", "Т", "У", "Х"};
    ArrayList<String> carNumbers;


    public BeatifulCarNumber() {
       carNumbers = new ArrayList<>();
       _generateCarNumbers();
    }

    void generateCarNumbers() {
        for(int i = 111; i <= 999; i += 111) {
            for(int r = 1; r < 200; r++) {
                String format = "";
                if(r < 100) format = "%s%03d%s%s%02d";
                else format = "%s%03d%s%s%03d";
                for (int j = 0; j < words.length - 2; j++) {
                    for (int k = j + 1; k < words.length - 1; k++) {
                        carNumbers.add(

                                String.format(format,
                                        words[j],
                                        i,
                                        words[k],
                                        words[k + 1],
                                        r
                                )
                        );
                    }
                }
            }
        }
    }

    void _generateCarNumbers() {
        for(int i = 111; i <= 999; i += 111) {
            for(int r = 1; r < 200; r++) {
                String format = "";
                if(r < 100) format = "%s%03d%s%s%02d";
                else format = "%s%03d%s%s%03d";
                for (int x = 0; x < words.length - 1 ; x++) {
                    for (int y = 0; y < words.length - 1; y++) {
                        for(int z = 0; z < words.length -1; z++) {
                            if(x != y && y != z && z != x) {
                                carNumbers.add(

                                        String.format(format,
                                                words[x],
                                                i,
                                                words[y],
                                                words[z],
                                                r
                                        )
                                );
                            }
                        }
                    }
                }
            }
        }
    }

    public void show(int start ,int end) {
        for(int i = start; i < end; i++) {
            System.out.println(carNumbers.get(i));
        }
        System.out.println(carNumbers.size());
    }


}
