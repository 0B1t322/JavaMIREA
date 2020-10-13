package ru.demin.pract11;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Bot { // играет за O
    private Random random;
    protected TTTMatr matr;
    protected Component[] btns;
    public Bot(TTTMatr matr, Component[] btns) {
        this.matr = matr;
        this.btns = btns;
        this.random = new Random();
    }

    public void makeMove() {
        int rowMin = 0;
        int rowMax = 2;

        var Matr = matr.getMatr();


        int y = random.nextInt(2); // рандомное число колонки

        while (Matr[y][rowMin] != 0 && rowMin < matr.SIZE) {
            rowMin++;
        }

        while (Matr[y][rowMax] != 0 && rowMax >= 0) {
            rowMax--;
        }

        int x = rowMin + random.nextInt(rowMax - rowMin);


        int index = matr.SIZE * y + x;

        JButton btn = (JButton) btns[index];


        btn.doClick();
    }
}
