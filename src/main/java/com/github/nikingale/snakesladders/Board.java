package com.github.nikingale.snakesladders;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Nikhil Ingale 09-04-2021
 */

public class Board {

    private static Logger LOG = Logger.getLogger(Board.class);

    private List<Snake> snakes;
    private List<Ladder> ladders;
    private int size;

    public Board() {
        this(100);
    }

    public Board(int size) {
        this.size = size;
        snakes = new LinkedList<>();
        ladders = new LinkedList<>();
        setupBoard();
    }

    private void setupBoard() {
        // create snakes
        snakes.add(new Snake(97, 78));
        snakes.add(new Snake(95, 56));
        snakes.add(new Snake(88, 24));
        snakes.add(new Snake(62, 18));
        snakes.add(new Snake(36, 6));
        snakes.add(new Snake(48, 26));
        snakes.add(new Snake(32, 10));

        // create ladders
        ladders.add(new Ladder(80, 99));
        ladders.add(new Ladder(71, 92));
        ladders.add(new Ladder(50, 67));
        ladders.add(new Ladder(28, 76));
        ladders.add(new Ladder(21, 42));
        ladders.add(new Ladder(8, 30));
        ladders.add(new Ladder(4, 14));
    }

    public int findFinalPosition(int currentPosition) {
        int finalPosition = currentPosition;
        for (Snake snake : snakes) {
            if (snake.getStart() == currentPosition) {
                finalPosition = snake.getEnd();
                LOG.info("Oops! Snake bite, going down to " + finalPosition);
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == currentPosition) {
                finalPosition = ladder.getEnd();
                LOG.info("Bingo! Ladder lift, climbing to " + finalPosition);
            }
        }
        return finalPosition;
    }

    public boolean isPositionInvalid(int position) {
        return position > size;
    }

    public boolean isWinningPosition(int position) {
        return position == this.size;
    }

}