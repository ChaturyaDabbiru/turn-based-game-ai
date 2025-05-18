package org.game.gameState;

public class Player {

    String playerSymbol;

    public Player(String symbol)
    {
        this.playerSymbol = symbol;
    }
    public String getPlayerSymbol()
    {
        return this.playerSymbol;
    }

    public Player flip()
    {
        return new Player(playerSymbol.equals("X") ? "O" : "X");
    }
}
