package ru.demin.pract11;

import ru.demin.pract11.Matrer;

public class TTTMatr implements Matrer {
    // -1 - is O
    // 1 - is a X
    private byte[][] matr;
    final byte SIZE = 3;
    public TTTMatr() {
        matr = new byte[3][3];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matr[i][j] = 0;
            }
        }
    }

    public byte[][] getMatr() {
        return matr;
    }

    public boolean setNum(byte num , int col, int row) {
        matr[col][row] = num;
        return checkIfEnd();
    }

    private boolean checkIfEnd() {
        if( checkDiagonal(-1) || checkDiagonal(1) ||
            checkLanes(-1)    || checkLanes(1)     )
        {
                return true;
        }

        return false;

    }

    private boolean checkDiagonal(int num) {
        boolean toRight, toLeft;
        toRight = true;
        toLeft = true;
        for(int i = 0; i < SIZE; i++) {
            toRight &= (matr[i][i] == num);
            toLeft  &= (matr[SIZE-i-1][i] == num);
        }

        if(toLeft || toRight) return true;

        return false;
    }

    private boolean checkLanes(int num) {
        boolean cols, rows;
        for(int col = 0; col < SIZE; col++) {
            cols = true;
            rows = true;
            for(int row = 0; row < SIZE; row++) {
                cols &= (matr[col][row] == num);
                rows &= (matr[row][col] == num);
            }
            if(cols || rows) return true;
        }

        return false;
    }
}
