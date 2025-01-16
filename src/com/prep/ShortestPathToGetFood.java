package com.prep;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {


    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };
        int steps = getFood(grid);
        System.out.println(steps);
    }

    private static int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int steps = 0;
        int ans = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    q.add(new int[]{i, j, 0});
                    break;
                }
            }
        }
        //initilize direction array
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int step = current[2];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 'X' || grid[newX][newY] == 'V') {
                    continue;
                }
                if (grid[newX][newY] == '#') {
                    return step + 1;
                }
                grid[newX][newY] = 'V';
                q.add(new int[]{newX, newY, step+1});
            }

        }
        return -1;
    }

    //DFS run into TLE

//    private static int getFood(char[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int steps = -1;
//        dp = new int[m+1][n+1];
//        int iStart =0;
//        int jStart =0;
//        boolean flag = false;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                dp[i][j] = Integer.MAX_VALUE;
//                if(grid[i][j]=='#')
//                    flag = true;
//                else if(grid[i][j]=='*'){
//                    iStart =i;
//                    jStart =j;
//                }
//            }
//        }
//        if(!flag) return -1;
//        getFoodSolve(iStart,jStart, grid,m,n,0);
//       return steps1 == Integer.MAX_VALUE ? -1:steps1;
//    }
//
//    private static void getFoodSolve(int i, int j, char[][] grid, int m, int n, int count) {
//        //check boundary condition
//        if(i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == 'X')return;
//        if(count > dp[i][j] || count > steps1) return;
//        dp[i][j] = count;
//        //encounter food
//        if(grid[i][j] == '#'){
//            steps1 = Math.min(steps1, dp[i][j]);
//            return;
//        }
//            getFoodSolve(i+1, j, grid, m,n,count+1); //down
//            getFoodSolve(i, j+1, grid, m,n, count+1); //right
//            getFoodSolve(i-1, j, grid, m,n, count+1); //up
//            getFoodSolve(i, j-1, grid, m,n, count+1); //left
//    }
}
