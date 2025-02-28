package tic_tac_toe;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe Game Started");
        Game game = new Game(3,2);
        game.start();

    }
}
