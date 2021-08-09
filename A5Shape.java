package sample;

public class A5Shape {
    private int x;
    private int y;
    private int radius;


    A5Shape(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    A5Shape(){
        x=0;
        y=0;
        radius=0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
