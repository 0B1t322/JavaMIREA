package ru.demin.pract13_1;

import java.util.List;

public class Delete implements CommandsHandler<List<String>> {

    @Override
    public void makeCommand(List<String> someList, String[] args) {
        if(args.length > 1) {
            System.out.println("to much args");
            return;
        }

        if(args.length == 0) {
            System.out.println("You dont give args");
            return;
        }

        int index = -1;
        try {
            index = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("You dont give a index");
            return;
        }

        if(index > someList.size() - 1 || index < 0) {
            System.out.println("Index out of range");
            return;
        }

        someList.remove(index);
    }
}
