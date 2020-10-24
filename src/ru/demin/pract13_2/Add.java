package ru.demin.pract13_2;

import ru.demin.pract13_1.CommandsHandler;

import java.util.TreeSet;

public class Add implements CommandsHandler<TreeSet<String>> {
    @Override
    public void makeCommand(TreeSet<String> someList, String[] args) {
        if(args.length == 0) {
            System.out.println("You dont give a email");
            return;
        }

        String email = args[0];
        if(Email.isEmail(email)) {
            someList.add(email);
        } else {
            System.out.println("It's invalid email");
        }
    }
}
