package com.github.nikingale.marsrover;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class Surface {

    private int startX = 0;
    private int startY = 0;
    private int endX;
    private int endY;

    public Surface() {
        endX = 5;
        endY = 5;
    }

    public Surface(int endX, int endY) {
        this.endX = endX;
        this.endY = endY;
    }

    public boolean isPositionValid(Position position) {
        return (position.getX() <= endX && position.getX() >= startX) &&
                (position.getY() <= endY && position.getY() >= startY);
    }

}