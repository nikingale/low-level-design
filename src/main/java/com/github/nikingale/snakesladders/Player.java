package com.github.nikingale.snakesladders;

/**
 * @author Nikhil Ingale 09-04-2021
 */

public class Player {

    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }

    public int rollDice(Dice dice) {
        return dice.roll();
    }

    public void moveToPosition(int finalPosition) {
        position = finalPosition;
    }

    public void moveByPlaces(int moves) {
        position += moves;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

}