package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Bot { // играет за O
    private Random random;
    private MyBool active = new MyBool(false);
    protected TTTMatr matr;
    protected Component[] btns;
    public Bot(TTTMatr matr, Component[] btns) {
        this.matr = matr;
        this.btns = btns;
        this.random = new Random();
    }

    public void setActive(MyBool active) {
        this.active = active;
    }

    public boolean getActive() {
        return active.getVar();
    }

    public void makeMove() {
        int rowMin = 0;
        int rowMax = 2;

        var Matr = matr.getMatr();

        int y;
        do {
            y = random.nextInt(3); // рандомное число колонки
        }
        while(!isHaveZero(y));

        while (Matr[y][rowMin] != 0 && rowMin < matr.SIZE) { // находим минимальный индекс строки
            rowMin++;
        }

        while (Matr[y][rowMax] != 0 && rowMax >= 0) { // находим максимальный индекс строки
            rowMax--;
        }

        int x = rowMin + random.nextInt(rowMax - rowMin + 1); // рандомим



        int index = matr.SIZE * y + x;

        JButton btn = (JButton) btns[index];


        btn.doClick();
    }

    private boolean isHaveZero(int y) {
        var Matr = this.matr.getMatr();
        boolean find = false;
        for(int i = 0; i < matr.SIZE; i++) {
            if(Matr[y][i] == 0) find = true;
        }

        return find;
    }
}
