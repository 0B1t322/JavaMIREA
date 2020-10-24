package ru.demin.pract13_1;

import java.util.List;

public interface CommandsHandler<E> {
    void makeCommand(E someList, String[] args);
}
