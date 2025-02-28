package tic_tac_toe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private int size;
    private Deque<Player> players;

    public Game(int size, int noOfPlayers){
        this.size = size;
        this.board = new Board(size);
        this.players = new LinkedList<>();
        start();
    }

    public void start(){
        boolean winner = false;
        Player player1 = new Player("player1", new PieceX(PieceType.X));
        Player player2 = new Player("player2", new PieceO(PieceType.O));
        players.addFirst(player1);
        players.addLast(player2);
        while(true){
            Player currPlayer = players.pollFirst();
            board.displayBoard();
            System.out.println("Current Player is : " + currPlayer.name + "("+currPlayer.playingPiece.pieceType+")");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Give a location for placing the piece: ");
            String loc = scanner.nextLine();
            String[] indices = loc.split(",");
            int x = Integer.parseInt(indices[0]);
            int y = Integer.parseInt(indices[1]);
            board.placePiece(Integer.parseInt(indices[0]), Integer.parseInt(indices[1]), currPlayer.playingPiece);
            if (!isWinner(x, y, currPlayer.playingPiece.pieceType)) {
                System.out.println("Found winner!!!");
            }
            else{
                winner=true;
                System.out.println("The winner is " + currPlayer.name + "!!!");
                break;
            }
            board.displayBoard();
            players.addLast(currPlayer);

        }
    }

    public boolean isWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {

            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {

            if(board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
