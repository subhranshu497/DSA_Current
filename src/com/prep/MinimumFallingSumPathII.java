package com.prep;

public class MinimumFallingSumPathII {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingSumII(grid));
    }

    private static int minFallingSumII(int[][] grid) {
        int ans =Integer.MAX_VALUE;
        int[][]dp = new int[grid.length][grid.length];
        for(int lastRow=0;lastRow< dp.length;lastRow++){
            dp[grid.length-1][lastRow] = grid[grid.length-1][lastRow];
        }
        for(int i=grid.length-2;i>=0;i--){
            for(int j=0;j< grid.length;j++){
                int minVal = Integer.MAX_VALUE;
                for(int nextCol=0;nextCol< grid.length;nextCol++){
                    if(j !=nextCol){
                        minVal = Math.min(minVal, dp[i+1][nextCol]);
                    }
                }
                dp[i][j] = grid[i][j]+minVal;
            }
        }
        for(int i=0;i<grid.length;i++){
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }
}
