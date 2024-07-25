package com.prep;

public class PathWithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int gold = getMaximumGold(grid);
        System.out.println(gold);
    }

    private static int getMaximumGold(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    int sum = dfsGold(grid, i,j,m,n);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    private static int dfsGold(int[][] grid, int i, int j, int m, int n) {
        //base case
        if(i <0 || i>=m || j<0 || j >=n || grid[i][j]==0) return 0;
        int temp = grid[i][j];
        grid[i][j] =0;
        int up = dfsGold(grid,i-1,j,m,n);
        int down = dfsGold(grid,i+1,j,m,n);
        int left = dfsGold(grid,i,j-1,m,n);
        int right = dfsGold(grid,i,j+1,m,n);
        grid[i][j] = temp;

        return temp+Math.max(Math.max(Math.max(up,down),left),right);
    }
}
