package com.github.nikingale.marsrover;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class TurnRightCommand implements NavigationCommand {

    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.rotateRight();
    }

}