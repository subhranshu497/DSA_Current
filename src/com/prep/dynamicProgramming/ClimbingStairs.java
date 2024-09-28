package com.prep.dynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n =3;
        int ways = climbingStair(n);
        //int way1 = climbingStairsBottomUp(n);
    }
//    private static int climbingStairsBottomUp(int n);
//    {
//        int [] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] =1;
//        dp[2] = 2;
//        if(n==0 || n==1 || n==2)return n;
//        for(int i=3;i<=n;i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }
    private static int climbingStair(int n) {
        //base condition
        if(n<0) return 0;
        if(n==0) return 1;
        int oneStep = climbingStair(n-1);
        int twoSteps = climbingStair(n-2);
        return oneStep+twoSteps;
    }

    //approach -2 - using memoization
    private static int climbingStairMemoSolve(int n, int [] memo){
        //base condition
        if(n<0) return 0;
        if(n==0) return 1;
        if(memo[n] !=-1)return memo[n];
        int oneStep = climbingStairMemoSolve(n-1, memo);
        int twoSteps = climbingStairMemoSolve(n-2, memo);
        return memo[n] = oneStep+twoSteps;
    }
    private static int climbingStairMemo(int n){
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbingStairMemoSolve(n,memo);
    }

    private static int climbingStairsWithConstantSpace(int n){
        if(n==1 || n==2) return n;
        int a = 1;
        int b = 2;
        int c =0;
        for(int i =3;i<=n;i++){
            c = a+b;
            a =b;
            b=c;
        }
        return c;
    }
}
