package tic_tac_toe;

public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }


    public void placePiece(int x, int y, PlayingPiece playingPiece){
        board[x][y] = playingPiece;
    }

    public void displayBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == null){
                    System.out.print("  |");
                }
                else{
                    System.out.print(board[i][j].pieceType.name() + "  |");
                }
            }
            System.out.println();
        }

        System.out.println("=============================");
    }


}
