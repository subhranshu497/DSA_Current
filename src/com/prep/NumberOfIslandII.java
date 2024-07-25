package com.prep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandII {
    public static void main(String[] args) {
        int [][] positions = {{0,0},{0,1},{1,2},{2,1}};
        int m=3;
        int n=3;
        List<Integer> islandCount = numIslandsTwo(m,n,positions);
        System.out.println(islandCount);
    }

    private static List<Integer> numIslandsTwo(int m, int n, int[][] positions) {
        List<Integer> results = new ArrayList<>();
        int posRow = positions.length;
        int posCol = positions[0].length;
        int[][] grid = new int[m][n];
        for(int[] position:positions){
            grid[position[0]][position[1]]=1;
            int count = countIsland(grid,m,n);
            results.add(count);
        }

        return results;
    }

    private static int countIsland(int[][] grid, int m, int n) {
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfsIsland(grid, i, j,m,n);
                    count +=1;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    grid[i][j]=1;
                }
            }
        }
        return count;
    }

    private static void dfsIsland(int[][] grid, int i, int j, int m, int n) {
       //base condition
        if(i<0 || j<0 || i>=m|| j>=n || grid[i][j] !=1) return;
        grid[i][j] =2;
        dfsIsland(grid, i, j+1,m,n);
        dfsIsland(grid, i, j-1,m,n);
        dfsIsland(grid, i+1, j,m,n);
        dfsIsland(grid, i-1, j,m,n);
    }
}
