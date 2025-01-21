package com.prep;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GridGame {
    public static void main(String[] args) {
        int [][] grid = {{2,5,4},{1,5,1}};
        long points = gridGame(grid);
        System.out.println(points);
    }

    private static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long points = Long.MAX_VALUE;
        long rowSum1 = 0;
        for(int i=0;i<n;i++){
            rowSum1 +=grid[0][i];
        }
        long rowSum2 = 0;
        for(int i=0;i<n;i++){
            rowSum1 -=grid[0][i];
            points = Math.min(points, Math.max(rowSum1, rowSum2));
            rowSum2 +=grid[1][i];
        }
        return points;
    }
}
