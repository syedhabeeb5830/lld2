package sanke_and_ladder;

import java.util.List;

public class Board {


    public int size;
    public int[] board;
    public List<Jump> jumps;
    public Board(int size, List<Jump> jumps){
        this.size = size;
        this.board = new int[size];
        this.jumps = jumps;
    }



    public Jump checkJumps(int pos){
        for(Jump jump: jumps){
            if(jump.start == pos){
                return jump;
            }
        }
        return null;
    }

}
