package chess;

import java.awt.*;

public abstract class Piece {
    private Color color;
    private boolean killed = false;
    public abstract boolean canMove(Board board, Cell startBlock, Cell endBlock);
    public Piece(Color color) {
        this.color = color;
    }
    public Color getPieceColor(){
        return color;
    }
    public boolean isKilled() {
        return killed;
    }
    public void setKilled(boolean killed) {
        this.killed = killed;
    }
}