package org.game;

import org.game.api.AIEngine;
import org.game.api.GameEngine;
import org.game.api.RuleEngine;
import org.game.gameState.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        AIEngine aiEngine = new AIEngine();
        RuleEngine ruleEngine = new RuleEngine();

        Board board = gameEngine.start("TicTacToe");

        //make moves

        int row, col;
        Scanner scanner = new Scanner(System.in);
        while (!ruleEngine.getState(board).getIsOver()) {

            System.out.println("Make your Move !");
            System.out.println(board);
            System.out.println();

            Player computer = new Player("O");
            Player human = new Player("X");

            row = scanner.nextInt();
            col = scanner.nextInt();

            Move oppMove = new Move(new Cell(row, col), human);
            gameEngine.move(board, oppMove);

            if(!ruleEngine.getState(board).getIsOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
        System.out.println("Game Result:" + ruleEngine.getState(board));
        System.out.println(board);
    }
}
