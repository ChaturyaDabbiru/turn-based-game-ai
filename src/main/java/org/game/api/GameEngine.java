package org.game.api;

import org.game.boards.TicTacToeBoard;
import org.game.gameState.*;

public class GameEngine {

    // Apis to expose to public
    public Board start(String type)
    {
        if(type.equals("TicTacToe")) return new TicTacToeBoard();
        else
            throw  new IllegalArgumentException();
    }

    public void move(Board board, Move move)
    {
        if(board instanceof TicTacToeBoard){
            board.move(move);
        }
        else {
            throw new IllegalArgumentException();
        }
    }



}

