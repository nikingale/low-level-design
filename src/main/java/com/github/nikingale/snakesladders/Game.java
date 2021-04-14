package com.github.nikingale.snakesladders;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author Nikhil Ingale 09-04-2021
 */

public class Game {

    private static Logger LOG = Logger.getLogger(Game.class);

    private Board board;
    private Dice dice;
    private List<Player> players;
    private Player winner;

    public Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public Player playGame() {
        while (this.winner == null) {
            startRound();
        }
        return this.winner;
    }

    private void startRound() {
        LOG.info("Starting round...");
        for (Player player : players) {
            LOG.info("");
            playerTurn(player);
            if (isWinner(player)) {
                this.winner = player;
                return;
            }
        }
    }

    private void playerTurn(Player player) {
        LOG.info(player.getName() + "'s turn");

        LOG.info("Rolling dice...");
        diceRollPause();
        int diceOutcome = player.rollDice(this.dice);
        LOG.info("Dice outcome is " + diceOutcome);

        int nextPosition = player.getPosition() + diceOutcome;
        if (board.isPositionInvalid(nextPosition)) {
            LOG.info("Can't move!");
            return;
        }

        player.moveByPlaces(diceOutcome);
        LOG.info("Move to " + player.getPosition());

        int finalPosition = board.findFinalPosition(player.getPosition());
        player.moveToPosition(finalPosition);
    }

    private boolean isWinner(Player player) {
        return board.isWinningPosition(player.getPosition());
    }

    public Player getWinner() {
        return winner;
    }

    private void diceRollPause() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ignored) {
        }
    }

}