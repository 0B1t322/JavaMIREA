package ru.demin.pract17;

public class Line {
    private String number;
    private String name;

    public Line() {

    }

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Line{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
