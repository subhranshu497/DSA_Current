package com.prep;

import java.util.Arrays;

public class MaximumNumberOfMovesInAGrid {

    private static int [] directions = {-1,0,1};
    public static void main(String[] args) {
        int [][] grid = {{3,2,4},{2,1,9},{1,1,7}};
        int moves = maxMoves(grid);
        System.out.println(moves);
    }

    private static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int moves = 0;
        int [][] memo = new int[m][n];
        for(int [] arr :memo)Arrays.fill(arr,-1);
        for(int i=0;i<m;i++){
            moves = Math.max(moves, maxMovesDFS(i,0,m,n,grid, memo));
        }
        return moves;
    }

    private static boolean outOfBoundCheck(int i, int j, int m, int n){
        if(i <0 || j<0 || i == m || j==n) return true;

        return false;
    }

    private static int maxMovesDFS(int i, int j, int m, int n, int[][] grid, int [][] memo) {
        int moves =0;
        if(memo[i][j] !=-1) return memo[i][j];
        for(int direction : directions){
            int newI = i+direction;
            int newJ = j+1;
            if(!outOfBoundCheck(newI, newJ, m,n) && grid[i][j] < grid[newI][newJ])
                moves = Math.max(moves, 1+maxMovesDFS(newI, newJ, m,n, grid,memo));
        }
        return memo[i][j]=moves;
    }


    private static int solveMaxMoves(int[][] grid, int m, int n, int i, int j, int [][] memo) {
        //base condition
        if(j == n-1){
            return 0;
        }
        if(memo[i][j] !=-1) return memo[i][j];
        int right =0, up =0,down =0;
        if(grid[i][j] < grid[i][j+1])
             right =1+solveMaxMoves(grid, m, n,i ,j+1, memo);
        if(i+1<m && grid[i][j] < grid[i+1][j+1])
             down =1+ solveMaxMoves(grid, m, n,i+1 ,j+1, memo);
        if(i-1>=0 && grid[i][j] < grid[i-1][j+1])
             up =1+solveMaxMoves(grid, m, n,i-1 ,j+1, memo);

        return memo[i][j]=Math.max(right, Math.max(up,down));
    }
}
