package ru.demin.pract13_1;

import java.util.List;

public interface CommandsHandler {
    void makeCommand(List<String> someList, String[] args);

    void makeCommand(List<String> someList);
}
