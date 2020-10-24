package ru.demin.old.pract3;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.printf("Radius %s\n", circle.getRadius());

        circle.setRadius(2);
        System.out.printf("Radius %s\n", circle.getRadius());
    }
}
