package ru.demin.old.pract3;

public class Head {
    String eyeColor;

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public Head(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void blink() {
        System.out.println("Blink");
    }
}
