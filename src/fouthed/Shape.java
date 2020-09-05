package fouthed;

public abstract class Shape {
    protected int x;
    protected int y;

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    abstract float perimetr();
    abstract float square();
}
