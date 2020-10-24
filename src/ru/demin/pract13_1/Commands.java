package ru.demin.pract13_1;

import java.util.HashMap;
import java.util.Map;

public class Commands<E> {
    private Map<String, E> commandsList;

    public Commands() {
        commandsList = new HashMap<>();
    }

    public void addCommand(String commandName, E commandsHandler) {
        commandsList.put(commandName, commandsHandler);
    }

    public E getCommand(String commandName)  {
        return commandsList.get(commandName);
    }
}
