package com.prep;

public class LakePerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(isLandPerimeter(grid));
    }

    private static int isLandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int up,down,left, right =0;
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    if(i==0)up=0;
                    else up = grid[i-1][j];
                    if(j==0)left=0;
                    else left = grid[i][j-1];
                    if(i==rows-1)down=0;
                    else down = grid[i+1][j];
                    if(j==cols-1)right=0;
                    else right = grid[i][j+1];
                    count +=4-(up+down+left+right);
                }
            }
        }
        return count;
    }
}
