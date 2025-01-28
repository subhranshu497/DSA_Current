package com.prep;

public class MaximumNumberofFishinaGrid {
    public static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static boolean[][] visited;
    public static void main(String[] args) {
        int [][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        int fishes = findMaxFish(grid);
        System.out.println(fishes);
    }

    private static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fishes = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] !=0){
                    visited = new boolean[m][n];
                    fishes = Math.max(findMaxFishDFS(grid, m,n,i,j), fishes);
                }
            }
        }

        return fishes;
    }

    private static int findMaxFishDFS(int[][] grid, int m, int n, int i, int j) {
        visited[i][j] = true;
        int fish =0;
        if(grid[i][j]==0) return fish;
        fish +=grid[i][j];
        for(int [] direction:directions){
            int i_ =i+direction[0];
            int j_ = j+direction[1];
            if(isValidToCatchFishes(i_,j_,m,n,grid)){
                if(!visited[i_][j_])
                    fish +=findMaxFishDFS(grid,m,n,i_,j_);
            }
        }
        return fish;
    }

    private static boolean isValidToCatchFishes(int i, int j, int m, int n, int[][] grid) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

}
