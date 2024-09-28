package com.prep.dynamicProgramming;

import java.util.Arrays;

/**
 * find out the nth fibonacci number using dynamic Programming
 */
public class FibonacciDP {
    public static void main(String[] args) {
        int n = 3;
        int result = fibonaccinumber(n);
        System.out.println(result);
    }

    private static int fibonaccinumber(int n) {
        //base condition
        if(n<=1) return n;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solvefib(n,dp);
    }

    private static int solvefib(int n, int[] dp) {
        if(n<=1) return n;
        return dp[n] = solvefib(n-1,dp)+solvefib(n-2, dp);
    }

    //using bottom up approach
    private static int fibBottomUp(int n){
        int [] dp = new int[n+1];
        dp[0] =0;
        dp[1] =1;
        for(int i=2;i<=n;i++){
            dp[i] =dp[n-1]+dp[n-2];
        }
        return dp[n];
    }
    private static int fibBottomupConstantSpace(int n){
        if(n<=1) return n;
        int a =0;
        int b=1;
        int result = 0;
        for(int i=2;i<=n;i++){
            result = a+b;
            a =b;
            b= result;
        }
        return result;
    }
}
