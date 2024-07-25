package com.prep;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n =4;
        System.out.println(tribonacci(n));
    }

    private static int tribonacci(int n) {
        if(n<3) return n>0?1:0;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        if(n>2){
            for(int i=3;i<dp.length;i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
}
