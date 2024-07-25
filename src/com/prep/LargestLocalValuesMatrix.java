package com.prep;

public class LargestLocalValuesMatrix {
    public static void main(String[] args) {
        int[][] grid ={{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int [][] result = largestLocal(grid);
        //print
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] grid, int x, int y){
        int max = 0;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                maxLocal[i][j]= findMax(grid, i,j);
            }
        }
        return maxLocal;
    }
}

