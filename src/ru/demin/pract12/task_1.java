package ru.demin.pract12;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class task_1 {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563, а Маша - 30000 рублей";
        text = text.replace(",","");
        text = text.replace("-","");
        String[] words = text.split(" ");
        String[] names = {"Вася", "Маша"};

        int firstNum = getSalaryFromName(words, names[0]);
        int secondNum = getSalaryFromName(words, names[1]);

        System.out.println(firstNum + secondNum);
    }

    // if don't find return -1
    public static int findFirstIndex(String[] mass, String str) {
        for (int i = 0; i < mass.length; i++) {
            if(mass[i].equals(str)) return i;
        }
        return -1;
    }

    // if dont find return -1
    public static int getSalaryFromName(String[] words, String name) {
        int firstNum = -1;
        int i = findFirstIndex(words, name);
        while (i < words.length) {
            try
            {
                firstNum = Integer.valueOf(words[i]);
            }
            catch (NumberFormatException e)
            {
                i++;
                continue;
            }

            break;
        }
        return firstNum;
    }
}
