package ru.demin.old.pract3;

public class Leg {
    private float lenght;

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public float getLenght() {
        return lenght;
    }

    public Leg(float lenght) {
        this.lenght = lenght;
    }

    public void makeStep() {
        System.out.println("Step taken");
    }
}
