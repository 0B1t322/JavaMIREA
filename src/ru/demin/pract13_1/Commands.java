package ru.demin.pract13_1;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    private Map<String, CommandsHandler> commandsList;

    public Commands() {
        commandsList = new HashMap<>();
    }

    public void addCommand(String commandName, CommandsHandler commandsHandler) {
        commandsList.put(commandName, commandsHandler);
    }

    public CommandsHandler getCommand(String commandName)  {
        return commandsList.get(commandName);
    }
}
