package ru.demin.pract13_1;

import java.util.List;

public class Add implements CommandsHandler {

    @Override
    public void makeCommand(List<String> someList, String... args) {
        if(args.length < 1) {
            System.out.println("Args is not given");
            return;
        }

        if(args.length == 1) {
            someList.add(args[0]);
        } else if(args.length > 1) {
            int index = -1;
            try {
                index = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                StringBuilder toDo = new StringBuilder();
                for(int i = 0; i < args.length; i++) toDo.append(args[i] += " ");
                someList.add(toDo.toString());
                return;
            }
            StringBuilder toDo = new StringBuilder();
            for(int i = 1; i < args.length; i++) toDo.append(args[i] += " ");

            if(index == -1) {
                someList.add(toDo.toString());
            } else {
                try {
                    someList.add(index, toDo.toString());
                } catch (IndexOutOfBoundsException e) {
                    someList.add(toDo.toString());
                }
            }

        }
    }

    @Override
    public void makeCommand(List<String> someList) {

    }
}
