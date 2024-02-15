package com.prep;

/**
 * Leetcode # 279
 */
public class PerfectSquares {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(numSquares(n));
    }

    private static int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int minValue = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int rem = i - j*j;
                if(dp[rem]<minValue) minValue = dp[rem];
            }
            dp[i] = minValue+1;
        }
        return dp[n];
    }
}
