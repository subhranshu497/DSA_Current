package com.prep;

/**
 * Leetcode # 70
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climb(n));
    }

    private static int climb(int n) {
        int[] dp = new int[n];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[0] =1;
        dp[1] =2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    private static int climbRecursion(int n) {
        return climbStairHelper(0, n);
    }

    private static int climbStairHelper(int i, int n) {
        if(i > n) return 0;
        if(i==n) return 1;
        return climbStairHelper(i+1, n)+climbStairHelper(i+2,n);
    }
}
