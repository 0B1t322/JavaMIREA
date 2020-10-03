package ru.demin.pract5;

public class MovablePoints implements Movable{
    MovablePoint pointF;
    MovablePoint pointS;

    public MovablePoints(MovablePoint pointF, MovablePoint pointS) {
        this.pointF = pointF;
        this.pointS = pointS;
    }

    public boolean checkSpeed() {
        if(pointF.getSpeed() != pointS.getSpeed()) {
            System.out.println("Скорость разная");
            return false;
        }
        return true;
    }

    @Override
    public void Move(int toX, int toY) {
        if(checkSpeed()) {
            pointF.Move(toX, toY);
            pointS.Move(toX, toY);
        }
    }
}
