package com.github.nikingale.snakesladders;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Nikhil Ingale 09-04-2021
 */

public class GameDriver {

    private static Logger LOG = Logger.getLogger(GameDriver.class);

    public static void main(String[] args) {
        LOG.info("Setting up the game");
        Board board = new Board();
        Dice dice = new Dice();
        Player player1 = new Player("Player-1");
        Player player2 = new Player("Player-2");
        Player player3 = new Player("Player-3");
        List<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        Game game = new Game(board, dice, players);
        Player winner = game.playGame();
        LOG.info("Winner is " + winner);
    }

}