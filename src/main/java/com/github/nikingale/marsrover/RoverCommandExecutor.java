package com.github.nikingale.marsrover;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class RoverCommandExecutor {

    public void executeCommand(NavigationCommand command) throws Exception {
        command.execute();
    }

}