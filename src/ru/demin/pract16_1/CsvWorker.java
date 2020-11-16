package ru.demin.pract16_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CsvWorker {
    List<String[]> table;

    public CsvWorker(List<String[]> table) {
        this.table = table;
    }

    public List<String> getCol(String name) {
        int index = Arrays.asList(table.get(0)).indexOf(name);
        if(index == -1) throw new NoSuchElementException();

        ArrayList<String> col = new ArrayList<>();

        for(int i = 1; i < table.size(); i++) {
            col.add(table.get(i)[index]);
        }

        return col;
    }
}
