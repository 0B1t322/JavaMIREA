package ru.demin.pract4;

public class Circle extends Shape {
    private float radius;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    float perimetr() {
        return (float) Math.PI * radius * 2;
    }

    @Override
    float square() {
        return (float) Math.PI * radius * radius;
    }
}
