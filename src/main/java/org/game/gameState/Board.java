package org.game.gameState;

public interface Board {

    public abstract void move(Move move);
    public abstract Board copy();
}
