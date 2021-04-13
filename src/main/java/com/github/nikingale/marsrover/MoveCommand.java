package com.github.nikingale.marsrover;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class MoveCommand implements NavigationCommand {

    private Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() throws Exception {
        rover.move();
    }

}