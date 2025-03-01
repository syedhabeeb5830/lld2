package sanke_and_ladder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {


    private Board board;
    private Deque<Player> playersDeque;

    private Dice dice;

    private int numberOfPlayers;
    private int size;
    public Game(int size, int numberOfPlayers, int numberOfDice){
        this.size = size;
        this.numberOfPlayers = numberOfPlayers;
        this.dice = new Dice(numberOfDice);
        this.playersDeque = new LinkedList<>();
        initialize();
    }


    private void initialize(){

        // can make it dynamic

        List<Jump> jumps = new ArrayList<>();
        jumps.add( new Jump(25, 5) );
        jumps.add( new Jump(34, 2) );
        jumps.add( new Jump(55,41 ) );
        jumps.add( new Jump(25, 5) );
        jumps.add( new Jump(98, 8) );


        jumps.add( new Jump(4,14));
        jumps.add( new Jump(26,77));
        jumps.add( new Jump(77, 91));
        jumps.add( new Jump(17, 60));
        jumps.add( new Jump(40, 80));

        board = new Board(this.size, jumps);

        Player player1 = new Player("Player1", 0);
        Player player2 = new Player("Player2", 0);

        playersDeque.addLast(player1);
        playersDeque.addLast(player2);

    }



    public void startGame(){

        boolean winner = false;

        while(!winner){
            Player currentPlayer = playersDeque.pollFirst();
            System.out.println("The current Player "+ currentPlayer.id + " is at position: " + currentPlayer.currentPosition);

            int run = dice.rollDice();
            int newPosition = run + currentPlayer.currentPosition;
            Jump jump = board.checkJumps(newPosition);
            // if encounter jumps

            if(jump!= null){
                currentPlayer.currentPosition = jump.end;
                if(jump.start < jump.end){
                    System.out.println("Founder Ladder :) ***");
                }
                else{
                    System.out.println("Bitten by Snake :( ^^^");
                }
                System.out.println("Took a jump from " + newPosition + " -> " + jump.end);
            }
            else{
                currentPlayer.currentPosition = newPosition;
                if(newPosition >= this.size){
                    winner= true;
                    System.out.println("The winner is: " + currentPlayer.id + "!!!!!!!!!!!!!!!!!!!");
                }
            }

            System.out.println(currentPlayer.id+"'s new position is at cell" + currentPlayer.currentPosition);

            System.out.println();
            System.out.println();
            // else
                // check if it's a winner if yes then break


            // put the currplayer to deque
            playersDeque.addLast(currentPlayer);
        }
    }








}
