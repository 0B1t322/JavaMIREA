package ru.demin.pract13_1;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> toDoList; // хранит задачи
    private Commands commands;

    public ToDoList() {
        toDoList = new ArrayList<>();
        commands = new Commands();

        commands.addCommand("ADD", new Add());
        commands.addCommand("LIST", new ListCmd());
        commands.addCommand("EDIT", new Edit());
        commands.addCommand("DELETE", new Delete());
    }

    public void ReadCommand(String command, String[] args) {
        try {
            commands.getCommand(command).makeCommand(toDoList, args);
        } catch (NullPointerException e) {
            System.out.println("Uknown command");
            return;
        }

    }
}
