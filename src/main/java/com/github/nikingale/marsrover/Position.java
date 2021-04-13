package com.github.nikingale.marsrover;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class Position {

    private int x, y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String toString() {
        return x + " " + y + " " + direction.name().substring(0, 1);
    }

}