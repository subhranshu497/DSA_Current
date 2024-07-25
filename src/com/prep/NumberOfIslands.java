package com.prep;

public class NumberOfIslands {
    public static void main(String[] args) {
        int [][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(noOfIslands(grid));
    }

    private static int noOfIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    dfsIslandCounter(grid, rows, cols, i,j);
                    islandCount +=1;
                }
            }
        }
        return islandCount;
    }
    private static void dfsIslandCounter(int[][] grid,int rows, int cols, int i, int j){
        //base conditions
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j] !=1) return;

        grid[i][j]=2;
        dfsIslandCounter(grid, rows, cols, i-1, j);
        dfsIslandCounter(grid, rows, cols, i+1, j);
        dfsIslandCounter(grid, rows, cols, i, j-1);
        dfsIslandCounter(grid, rows, cols, i, j+1);
    }
}
