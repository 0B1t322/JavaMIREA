package ru.demin.pract13_2;

import ru.demin.pract13_1.CommandsHandler;

import java.util.TreeSet;

public class ListCmd implements CommandsHandler<TreeSet<String>> {
    @Override
    public void makeCommand(TreeSet<String> someList, String[] args) {
        if(args.length != 0) {
            System.out.println("LIST had not args");
            return;
        } else {
            for(var email : someList) {
                System.out.println(email);
            }
        }
    }
}
