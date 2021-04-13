package com.github.nikingale.marsrover;

import static com.github.nikingale.marsrover.Direction.*;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class Rover {

    private String name;
    private Position position;
    private Surface surface;

    public Rover(Position position, Surface surface) {
        this.position = position;
        this.surface = surface;
    }

    public void rotateLeft() {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(WEST);
                break;
            case WEST:
                position.setDirection(SOUTH);
                break;
            case SOUTH:
                position.setDirection(EAST);
                break;
            case EAST:
                position.setDirection(NORTH);
                break;
        }
    }

    public void rotateRight() {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(EAST);
                break;
            case WEST:
                position.setDirection(NORTH);
                break;
            case SOUTH:
                position.setDirection(WEST);
                break;
            case EAST:
                position.setDirection(SOUTH);
                break;
        }
    }

    public void move() throws Exception {
        switch (position.getDirection()) {
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            case EAST:
                position.setX(position.getX() + 1);
                break;
        }

        if (!surface.isPositionValid(position)) {
            throw new Exception("Invalid position, exploration area boundary breached");
        }
    }

    public Position getPosition() {
        return position;
    }

}