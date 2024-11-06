package com.prep.Backtracking1;

public class UniquePathsIII {
    private static int result =0;
    private static int m;
    private static int n;
    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    private static int emptyCells;
    public static void main(String[] args) {
        int [][] grid = {{0,1},{2,0}};
        int paths = uniquePathsIII(grid);
        System.out.println(paths);
    }

    //1 = start , 0 = can walk, -1 = obstacle, 2 = destination
    private static int uniquePathsIII(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        emptyCells = 0;
        int currCount =0;
        int startX = -1;
        int startY = -1;

        //first traverse the grid to find start , dest, count of cell robot can walk
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j]==0)emptyCells++;
                if(grid[i][j]==1){
                    emptyCells++;
                    startX = i;
                    startY =j;
                }
            }
        }

        backtrackForUniquePathIII(startX,startY, currCount,grid);

        System.out.println("emptyCells   "+emptyCells);
        return result;
    }

    private static void backtrackForUniquePathIII(int i, int j, int count, int[][] grid) {
        //boundary condition
        if(i < 0 || j < 0 || i >=m || j >=n || grid[i][j] ==-1) return;
        //result yeild
        if(grid[i][j] == 2){
            if(emptyCells==count){
                result++;
            }
            return;
        }
        //mark it visitied
        grid[i][j] = -1;
        for(int [] direction : directions){
            int newX = i+direction[0];
            int newY = j+direction[1];
                backtrackForUniquePathIII(newX, newY,count+1, grid);
        }
        grid[i][j] = 0;
    }
}
