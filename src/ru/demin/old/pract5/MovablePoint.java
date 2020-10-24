package ru.demin.old.pract5;

public class MovablePoint implements Movable {
    private int x, y;
    private int speed;

    public MovablePoint(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp(int toY) {
        if(toY < y) return;

        while (y < toY) {
            this.y += speed;
        }

    }

    public void moveDown(int toY) {
        if(toY > y) return;

        while (y > toY) {
            this.y -= speed;
        }

    }

    public void moveRight(int toX) {
        if(toX < x) return;

        while(x < toX) {
            this.x += speed;
        }
    }

    public void moveLeft(int toX) {
        if(toX > x) return;

        while(x > toX) {
            this.x -= speed;
        }
    }

    @Override
    public void Move(int toX, int toY) {
        if(x >= toX) {
            moveLeft(toX);
        } else {
            moveRight(toX);
        }

        if(y >= toY) {
            moveDown(toY);
        } else {
            moveUp(toY);
        }
    }
}
