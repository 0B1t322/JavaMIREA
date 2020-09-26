package fiveth;

import fouthed.Rectangle;

public class MovableRectangle extends Rectangle implements Movable {
    private int speed;

    public MovableRectangle(int speed ,int x, int y, int width , int height) {
        super(x, y, width, height);
        this.speed = speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
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

