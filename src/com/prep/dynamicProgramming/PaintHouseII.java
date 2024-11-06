package com.prep.dynamicProgramming;

public class PaintHouseII {
    public static void main(String[] args) {
        int [][] costs = {{1,5,3},{2,9,4}};
        int min = minCost2(costs);
        System.out.println(min);
    }

    private static int minCost2(int[][] costs) {
        int n=costs.length;
        int k = costs[0].length;
        int [][] dp = new int[n][k];
        //initialize the first row of dp
        int colMinFirst = Integer.MAX_VALUE;
        int colMinSecond = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            dp[0][j] = costs[0][j];
            if(costs[0][j] <=colMinFirst){
                colMinSecond = colMinFirst;
                colMinFirst = costs[0][j];
            }else if(costs[0][j] <=colMinSecond){
                colMinSecond = costs[0][j];
            }
        }
        //fill the dp
        for(int i=1;i<n;i++){
            int newFirstMin = Integer.MAX_VALUE;
            int newSecondMin = Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(colMinFirst == dp[i-1][j]){
                    dp[i][j] = colMinSecond+costs[i][j];
                }
                else{
                    dp[i][j] = colMinFirst+costs[i][j];
                }
                //also calculate first and second min
                if(dp[i][j] <=newFirstMin){
                    newSecondMin = newFirstMin;
                    newFirstMin = dp[i][j];
                }else if(dp[i][j] <=newSecondMin){
                    newSecondMin = dp[i][j];
                }
            }
            colMinFirst = newFirstMin;
            colMinSecond = newSecondMin;
        }
        //find min
        int min = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
}
