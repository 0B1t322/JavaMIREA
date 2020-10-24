package ru.demin.old.pract4;

public class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    float perimetr() {
        return (float) 4*side;
    }

    @Override
    float square() {
        return (float) side*side;
    }
}
