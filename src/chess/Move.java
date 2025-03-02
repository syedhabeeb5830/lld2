package chess;

public class Move {
    private Cell startBlock;
    private Cell endBlock;
    public Move(Cell startBlock, Cell endBlock){

        this.endBlock= endBlock;
        this.startBlock = startBlock;
    }
    public boolean isValid(){
            return !(startBlock.getPiece().getPieceColor() == endBlock.getPiece().getPieceColor());
    }
    public Cell getStartBlock() {
        return startBlock;
    }
    public Cell getEndBlock() {
        return endBlock;
    }
}