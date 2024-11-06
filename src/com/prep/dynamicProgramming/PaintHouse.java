package com.prep.dynamicProgramming;

public class PaintHouse {
    public static void main(String[] args) {
        int [][] costs = {{1,5,7},{5,8,4},{3,2,9},{1,2,4}};
        int min = minCost1(costs);
        System.out.println(min);
    }

    private static int minCost1(int[][] costs) {
        int n = costs.length;
        int [][] dp = new int[n][3];
        //initialize the first row of the dp as is
        for(int j=0;j<3;j++){
            dp[0][j] = costs[0][j];
        }
        int min= Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int j=0;
            dp[i][j] = costs[i][j]+Math.min(dp[i-1][j+1],dp[i-1][j+2]);
            dp[i][j+1] = costs[i][j+1]+Math.min(dp[i-1][j],dp[i-1][j+2]);
            dp[i][j+2] = costs[i][j+2]+Math.min(dp[i-1][j+1],dp[i-1][j]);
        }
        //to find the min cost
        for(int j=0;j<3;j++){
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
}
