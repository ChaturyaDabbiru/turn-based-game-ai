package org.game.api;

import org.game.boards.TicTacToeBoard;
import org.game.gameState.Board;
import org.game.gameState.GameState;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RuleEngine {
    public GameState getState(Board board)
    {
        if( board instanceof TicTacToeBoard){

            TicTacToeBoard board1 = (TicTacToeBoard) board;

            GameState rowWin = outerTraversal((i, j) -> board1.getSymbol(i,j));
            if(rowWin.getIsOver())  return rowWin;

            GameState colWin = outerTraversal((i, j) -> board1.getSymbol(j,i));
            if(colWin.getIsOver())  return colWin;

            GameState diagWin = traverse(i-> board1.getSymbol(i,i));
            if(diagWin.getIsOver()) return diagWin;

            GameState revDiagWin = traverse(i-> board1.getSymbol(i,2-i));
            if(revDiagWin.getIsOver()) return revDiagWin;

            int countOfFilledCells = 0;

            for(int i =0;i<3;i++)
            {
                for(int j = 0;j<3;j++)
                {
                    if(board1.getSymbol(i,j) != null)
                    {
                        countOfFilledCells++;
                    }
                }
            }

            if(countOfFilledCells == 9)
                return new GameState(true, "-");
            else{
                return new GameState(false, "-");
            }
        }
        else {
            return new GameState(false, "-");
        }
    }

    private GameState outerTraversal(BiFunction<Integer, Integer, String> next)
    {
        GameState  result = new GameState(false, "-");
        for(int i =0;i<3;i++)
        {
            final int ii = i;
            GameState traversal = traverse(j -> next.apply(ii, j));
            if(traversal.getIsOver())
                result = traversal;
        }
        return result;
    }

    public GameState traverse(Function<Integer, String> traversal)
    {
        GameState  result = new GameState(false, "-");
            boolean possibleStreak = true;
            for (int j = 0; j < 3; j++) {
               if(traversal.apply(j) ==null || !traversal.apply(0).equals(traversal.apply(j))){
                   possibleStreak = false;
                   break;}
            }
            if (possibleStreak)
                result = new GameState(true, traversal.apply(0));
        return result;
    }
}
