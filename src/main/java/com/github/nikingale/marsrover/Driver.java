package com.github.nikingale.marsrover;

import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * @author Nikhil Ingale 26-03-2021
 */

public class Driver {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int endX, endY;
        int roverPosX, roverPosY;
        char roverDirection;
        String instructions;
        Surface explorationSurface;
        Rover rover;

        endX = scan.nextInt();
        endY = scan.nextInt();
        explorationSurface = new Surface(endX, endY);

        List<Position> roverFinalPositions = new LinkedList<>();

        String moreRovers;
        do {
            roverPosX = scan.nextInt();
            roverPosY = scan.nextInt();
            roverDirection = scan.next().charAt(0);
            Position position = new Position(roverPosX, roverPosY, getFormalDirection(roverDirection));
            rover = new Rover(position, explorationSurface);

            instructions = scan.next();

            // read instructions
            RoverCommandExecutor executor = new RoverCommandExecutor();
            for (int i = 0; i < instructions.length(); i++) {
                if (instructions.charAt(i) == 'L') {
                    executor.executeCommand(new TurnLeftCommand(rover));
                }
                else if (instructions.charAt(i) == 'R') {
                    executor.executeCommand(new TurnRightCommand(rover));
                }
                else if (instructions.charAt(i) == 'M') {
                    executor.executeCommand(new MoveCommand(rover));
                }
            }
            roverFinalPositions.add(rover.getPosition());

            System.out.println("deploy more rovers? : y/n");
            moreRovers = scan.next();

        } while (moreRovers.equals("y"));

        System.out.println("Rovers Final Positions---");
        for (Position roverFinalPosition : roverFinalPositions) {
            System.out.println(roverFinalPosition);
        }
    }

    private static Direction getFormalDirection(char direction) {
        switch (direction) {
            case 'W':
                return Direction.WEST;
            case 'S':
                return Direction.SOUTH;
            case 'E':
                return Direction.EAST;
            case 'N':
            default:
                return Direction.NORTH;
        }
    }

}