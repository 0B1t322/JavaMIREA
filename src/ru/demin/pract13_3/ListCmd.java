package ru.demin.pract13_3;

import ru.demin.pract13_1.CommandsHandler;

import java.util.Comparator;
import java.util.Map;

public class ListCmd implements CommandsHandler<Map<String, String>> {

    @Override
    public void makeCommand(Map<String, String> someList, String[] args) {
        if(args.length != 0) {
            System.out.println("LIST had not args");
            return;
        } else {
            someList.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(
                            action -> System.out.printf("%s - %s\n", action.getValue(), action.getKey())
                    );
        }
    }
}
