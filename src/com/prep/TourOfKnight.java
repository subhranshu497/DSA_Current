package com.prep;

public class TourOfKnight {
    // knight can move 8 directions . so lets initiate those
    private static int [][] directions = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int r =0;
        int c =0;
        int [][] result = tourKnight(m,n,r,c);
    }

    private static int[][] tourKnight(int m, int n, int r, int c) {
        int [][] board = new int[m][n];
        int [][] result = new int[m][n];
        //at the start initialize the board with -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++ ) {
                board[i][j] = -1;
            }
        }
        //start the game
        board[r][c] =0;
        tourKnightBacktrack(r,c,0,m,n,board, result);
        return result;
    }

    private static void tourKnightBacktrack(int i, int j, int step, int m, int n, int[][] board, int[][] result) {
        // Base Case
        if (step == m * n - 1) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    result[k][l] = board[k][l];
                }
            }
            return;
        }
        //candidates
        for(int [] direction:directions){
            int newX = direction[0]+i;
            int newY = direction[1]+j;

            //validate the move
            if(newX >=0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == -1){
                step++;
                board[newX][newY] = step;
                tourKnightBacktrack(newX, newY,step,m,n,result, board);
                board[newX][newY] = -1;
                step--;
            }
        }
    }
}
