package chess;

import chess.pieces.*;

import java.awt.*;

public class Board {
    private Cell[][] cells;
    private Color white;
    private Color black;
    public Board() {
        this.white = Color.WHITE;
        this.black = Color.BLACK;
        initializeBoard();
    }
    private void initializeBoard(){
        // Setting White Pieces
        cells[0][0] = new Cell(0,0,new Rook(white));
        cells[0][1] = new Cell(0,1,new Knight(white));
        cells[0][2] = new Cell(0,2,new Bishop(white));
        cells[0][3] = new Cell(0,3,new Queen(white));
        cells[0][4] = new Cell(0,4,new King(white));
        cells[0][5] = new Cell(0,5,new Bishop(white));
        cells[0][6] = new Cell(0,6,new Knight(white));
        cells[0][7] = new Cell(0,7,new Rook(white));
        for(int j=0; j<8 ; j++){
            cells[1][j] = new Cell(1,j,new Pawn(white));
        }
        //Setting Black Pieces
        cells[7][0] = new Cell(7,0,new Rook(black));
        cells[7][1] = new Cell(7,1,new Knight(black));
        cells[7][2] = new Cell(7,2,new Bishop(black));
        cells[7][3] = new Cell(7,3,new Queen(black));
        cells[7][4] = new Cell(7,4,new King(black));
        cells[7][5] = new Cell(7,5,new Bishop(black));
        cells[7][6] = new Cell(7,6,new Knight(black));
        cells[7][7] = new Cell(7,7,new Rook(black));
        for(int j=0; j<8 ; j++){
            cells[6][j] = new Cell(6,j,new Pawn(black));
        }
        // Defining rest of the cells having no pieces
        for(int i=2;i<6;i++){
            for( int j=0; j<8; j++){
                cells[i][j] = new Cell(i,j,null);
            }
        }
    }
}