package ru.mirea.para8;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListWorking {
    public static void main(String[] args) {
//        ArrayList<String> toDoList = new ArrayList<>();
//        toDoList.add("Сделать элтех");
//        toDoList.add(1, "привет");
//
//        for(var toDo: toDoList) {
//            System.out.println(toDo);
//            System.out.println(toDoList.indexOf(toDo));
//        }

        HashSet<String> words = new HashSet<>();
        words.add("Первое");
        words.add("Второе");



        for(var word : words) {
            System.out.println(word);
        }
    }
}
