package org.game.gameState;

public class GameState {
    boolean isOver;
    String winner;

    public GameState(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }

    public boolean getIsOver() {
        return this.isOver;
    }
    public String getWinner()  {
        return this.winner;
    }

    @Override
    public String toString()
    {
        return "GameResult{" +
                "isOver=" + isOver +
                ", winner='" + winner + '\'' +
                '}';
    }


}
