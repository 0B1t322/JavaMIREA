package ru.demin.pract13_2;

import ru.demin.pract13_1.Commands;
import ru.demin.pract13_1.CommandsHandler;

import java.util.TreeSet;

public class EmailList {
    private TreeSet<String> mailList;
    private Commands<CommandsHandler> commands;

    public EmailList() {
        mailList = new TreeSet<>();
        commands = new Commands();

        commands.addCommand("LIST", new ListCmd());
        commands.addCommand("ADD", new Add());
    }

    public void ReadCommand(String command, String[] args) {
        try {
            commands.getCommand(command).makeCommand(mailList, args);
        } catch (NullPointerException e) {
            System.out.println("Uknown command");
            return;
        }
    }
}
