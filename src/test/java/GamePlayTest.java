import org.game.api.GameEngine;
import org.game.api.RuleEngine;
import org.game.gameState.Board;
import org.game.gameState.Cell;
import org.game.gameState.Move;
import org.game.gameState.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GamePlayTest {

    GameEngine gameEngine;
    RuleEngine ruleEngine;

    @Before
    public void setup()
    {
        gameEngine = new GameEngine();
        ruleEngine = new RuleEngine();
    }

    @Test
    public void checkForRowWin()
    {
        Board board = gameEngine.start("TicTacToe");
        //make moves
        int[][] firstPlayerMoves = new int[][]{{1,0}, {1,1}, {1,2}};
        int[][] secondPlayerMoves = new int[][]{{0,0}, {0,1}, {0,2}};

        playGame(board, firstPlayerMoves, secondPlayerMoves);
        Assert.assertTrue(ruleEngine.getState(board).getIsOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin()
    {
        Board board = gameEngine.start("TicTacToe");
        //make moves
        int[][] firstPlayerMoves = new int[][]{{0,0}, {1,0}, {2,0}};
        int[][] secondPlayerMoves = new int[][]{{0,1}, {0,2}, {1,1}};
        playGame(board, firstPlayerMoves, secondPlayerMoves);
        Assert.assertTrue(ruleEngine.getState(board).getIsOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForDiaWin()
    {
        Board board = gameEngine.start("TicTacToe");
        //make moves
        int[][] firstPlayerMoves = new int[][]{{0,0}, {1,1}, {2,2}};
        int[][] secondPlayerMoves = new int[][]{{0,1}, {0,2}, {1,0}};

        playGame(board, firstPlayerMoves, secondPlayerMoves);
        Assert.assertTrue(ruleEngine.getState(board).getIsOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForRevDiaWin()
    {
        Board board = gameEngine.start("TicTacToe");
        //make moves
        int[][] firstPlayerMoves = new int[][]{{0,2}, {1,1}, {2,0}};
        int[][] secondPlayerMoves = new int[][]{{0,0}, {0,1}, {1,0}};
        playGame(board, firstPlayerMoves, secondPlayerMoves);
        Assert.assertTrue(ruleEngine.getState(board).getIsOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForSecondPlayerWin()
    {
        Board board = gameEngine.start("TicTacToe");
        //make moves
        int[][] firstPlayerMoves = new int[][]{{1,0}, {1,1}, {2,0}};
        int[][] secondPlayerMoves = new int[][]{{0,0}, {0,1}, {0,2}};

        playGame(board, firstPlayerMoves, secondPlayerMoves);
        Assert.assertTrue(ruleEngine.getState(board).getIsOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    public void playGame(Board board, int[][] firstPlayerMoves, int[][] secondPlayerMoves)
    {
        int row, col;
        int next = 0;

        while (!ruleEngine.getState(board).getIsOver() ) {

            System.out.println("Make your Move !");
            System.out.println(board);
            System.out.println();

            Player first = new Player("X");
            Player second = new Player("O");

            row = firstPlayerMoves[next][0];
            col = firstPlayerMoves[next][1];

            Move firstPlayerMove = new Move(new Cell(row, col), first);
            gameEngine.move(board, firstPlayerMove);

            if(!ruleEngine.getState(board).getIsOver()) {

                int sRow = secondPlayerMoves[next][0];
                int sCol = secondPlayerMoves[next][1];

                Move computerMove = new Move(new Cell(sRow,sCol), second);
                gameEngine.move(board, computerMove);
            }
            next++;
        }
    }

}
