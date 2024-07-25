package com.prep;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheMaxSafestDistanceInGrid {

    public static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(List.of(0,0,1),List.of(0,0,0), List.of(0,0,0));
        int safestDist = maximumSafenessFactor(grid);
        System.out.println(safestDist);
    }

    private static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] matrix = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    q.add(new int[]{i,j});
                    matrix[i][j] =0;
                }
                else matrix[i][j] =-1;
            }
        }
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- >0){
                int[] current = q.poll();
                for(int[] d : dir){
                    int di = current[0]+d[0];
                    int dj = current[1]+d[1];
                    int val = matrix[current[0]][current[1]];
                    if (isValidCell(matrix, di, dj) && matrix[di][dj] == -1) {
                        // Update safeness factor and push to the queue
                        matrix[di][dj] = val + 1;
                        q.add(new int[]{di, dj});
                    }
                }
            }
        }
        // Binary search for maximum safeness factor
        int start = 0;
        int end = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Set end as the maximum safeness factor possible
                end = Math.max(end, matrix[i][j]);
            }
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidSafeness(matrix, mid)) {
                // Store valid safeness and search for larger ones
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    private static boolean isValidCell(int[][] matrix, int i, int j) {
        int n = matrix.length;
        return i >= 0 && j >= 0 && i < n && j < n;
    }
    private static boolean isValidSafeness(int[][] grid, int minSafeness) {
        int n = grid.length;

        // Check if the source and destination cells satisfy minimum safeness
        if (grid[0][0] < minSafeness || grid[n - 1][n - 1] < minSafeness) {
            return false;
        }

        Queue<int[]> traversalQueue = new LinkedList<>();
        traversalQueue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // Breadth-first search to find a valid path
        while (!traversalQueue.isEmpty()) {
            int[] curr = traversalQueue.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return true; // Valid path found
            }
            // Check neighboring cells
            for (int[] d : dir) {
                int di = curr[0] + d[0];
                int dj = curr[1] + d[1];
                // Check if the neighboring cell is valid, unvisited and satisfying minimum safeness
                if (isValidCell(grid, di, dj) && !visited[di][dj] && grid[di][dj] >= minSafeness) {
                    visited[di][dj] = true;
                    traversalQueue.add(new int[]{di, dj});
                }
            }
        }

        return false; // No valid path found
    }
}
