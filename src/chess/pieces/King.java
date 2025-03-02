package chess.pieces;

import chess.Cell;
import chess.Board;
import chess.Piece;

import java.awt.*;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }
    @Override
    public boolean canMove(Board board, Cell startBlock, Cell endBlock) {
        return false;
    }
}