package sanke_and_ladder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Snake & Ladder !!!");
        Game game = new Game(100, 2, 1);
        game.startGame();
    }
}
