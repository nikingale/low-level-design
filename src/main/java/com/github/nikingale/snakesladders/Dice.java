package com.github.nikingale.snakesladders;

import java.util.Random;

/**
 * @author Nikhil Ingale 09-04-2021
 */

public class Dice {

    private int size;
    private Random random;

    public Dice() {
        this(6);
    }

    public Dice(int size) {
        this.size = size;
        random = new Random();
    }

    public int roll() {
        return (random.nextInt(size) + 1);
    }

}