package ru.demin.old.pract3;

public class Hand {
    float lenght;

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public Hand(float lenght) {
        this.lenght = lenght;
    }

    public void clenchedFist() {
        System.out.println("Clenched fist");
    }
}
