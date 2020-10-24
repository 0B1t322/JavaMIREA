package ru.demin.pract13_1;

import java.util.List;

public class Edit implements CommandsHandler<List<String>> {

    @Override
    public void makeCommand(List<String> someList, String[] args) {
        if(args.length == 0) {
            System.out.println("You dont give a args");
            return;
        }

        int index = -1;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("You dont give a index in first arg");
            return;
        }

        if(index > someList.size() - 1 || index < 0) {
            System.out.println("Index out of range");
            return;
        }

        String todo = "";
        for(int i = 1; i < args.length; i++) {
            todo += args[i] + " ";
        }

        someList.remove(index);
        someList.add(index, todo);

    }
}
