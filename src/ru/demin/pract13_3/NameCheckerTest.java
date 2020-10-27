package ru.demin.pract13_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameCheckerTest {

    @Test
    void ifNameString() {
        String[] names = new String[] {
                "Vova", "Daniil", "Oleg", "Даниил", "dan", "даня", "Даниил-Джордан"
        };

        String ans = "";
        for(var name: names) {
            try {
                ans = NameChecker.ifNameString(name);
            } catch (IllegalStateException e) {
                fail(e + " in name: " + name);
            }
        }
    }
}