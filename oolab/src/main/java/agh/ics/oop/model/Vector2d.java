package agh.ics.oop.model;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Vector2d {

    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(Vector2d vector) {
        return "(" + vector.getX() + "," + vector.getY() + ")";
    }

    public boolean precedes(Vector2d other) {
        return x <= other.getX() && y <= other.getY();
    }

    public boolean follows(Vector2d other) {
        return x >= other.getX() && y >= other.getY();
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.getX(), y + other.getY());
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.getX(), y - other.getY());
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d( max(x, other.getX() ), max(y , other.getY()));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d( min(x, other.getX() ), min(y , other.getY()));
    }
    public Vector2d opposite(Vector2d other){
        return new Vector2d(-other.getX(),-other.getY());
    }
    public boolean equals(Vector2d other){
        return x == other.getX() && y == other.getY(); // come back to this and review

    }


}