package com.prep;

public class Tictactoe {
    int[] rows;
    int [] cols;
    int diagonal;
    int antiD;

    public Tictactoe(int n){
        rows = new int[n];
        cols = new int[n];
    }
    public int move(int row, int col, int player){
        int playerValue = (player==1)?1:-1;
        int size = rows.length;
        rows[row] +=playerValue;
        cols[col] +=playerValue;
        if(row==col) diagonal +=playerValue;
        if((row+col)==(size-1)) antiD +=playerValue;

        //winning condition
        if(Math.abs(rows[row])==size ||
                Math.abs(cols[col])==size ||
                Math.abs(diagonal)==size ||
                Math.abs(antiD)==size
        )return player;
        return 0;
    }
}
