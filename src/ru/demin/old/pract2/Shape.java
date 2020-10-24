package ru.demin.old.pract2;

public class Shape {
    private int x;
    private int y;
    private int edgeCounts;
    private String shapeName;

    public Shape(int x, int y, int edgeCounts ,String shapeName) {
        this.x = x;
        this.y = y;
        this.edgeCounts = edgeCounts;
        this.shapeName = shapeName;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getEdgeCounts() {
        return edgeCounts;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setEdgeCounts(int edgeCounts) {
        this.edgeCounts = edgeCounts;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", edgeCounts=" + edgeCounts +
                ", shapeName='" + shapeName + '\'' +
                '}';
    }
}
