package com.prep.dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPathSum {
    public static void main(String[] args) {
        int [][] grid = {{1,2,3},{4,5,6}};
        int minSum = minPathSum(grid);
        System.out.println(minSum);
    }

    private static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c=grid[0].length;
        return minPathSumHelper(0,0,r,c,grid, new HashMap<List<Integer>, Integer>());
    }

    private static int minPathSumHelper(int i, int j, int r, int c, int[][] grid, Map<List<Integer>, Integer> memo) {
        //base condition
        if(i==r || j==c) return Integer.MAX_VALUE;
        if(i==r-1 && j==c-1) return grid[i][j];
        List<Integer> position = List.of(i,j);
        if(memo.containsKey(position)) return memo.get(position);
        int result =grid[i][j]+Math.min(minPathSumHelper(i+1,j,r,c,grid,memo),minPathSumHelper(i,j+1,r,c,grid,memo));
        memo.put(position, result);
        return result;
    }
}
