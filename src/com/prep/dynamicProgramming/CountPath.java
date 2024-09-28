package com.prep.dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPath {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{1,1,1},{1,1,1}};
        int paths = countPaths(grid);
        System.out.println(paths);
    }

    /**
     * moves possible only right and down
     * 0 represent wall , i.e - no move is possible though the cell filled with 0
     * @param grid
     * @return
     */
    private static int countPaths(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        return countPathsHelper(0,0,m,n,grid, new HashMap<List<Integer>,Integer>());
    }

    private static int countPathsHelper(int i, int j, int m, int n, int[][] grid, Map<List<Integer>,Integer> memo) {
        //base conidition
        // out of bound
        if(i==m || j==n)return 0;
        //check for wall
        if(grid[i][j]==0) return 0;
        List<Integer> pos = List.of(i,j);
        if(memo.containsKey(pos)) return memo.get(pos);
        if(i==m-1 && j==n-1) return 1;
        int result= countPathsHelper(i+1, j,m,n,grid, memo)+countPathsHelper(i,j+1,m,n,grid, memo);
        memo.put(pos, result);
        return result;
    }
}
