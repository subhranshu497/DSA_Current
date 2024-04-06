package com.prep.hackerRank.RecursionBackTracking;

/**
 * Davis has a number of staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
 *
 * Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase, module  on a new line.
 */
public class DavisStairCase {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(stepPermsDP(n));
    }

    private static int stepPerms(int n) {
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
       return (stepPerms(n-1)%1000000007)+(stepPerms(n-2)%1000000007)+(stepPerms(n-3)%1000000007);
    }
    private static int stepPermsDP(int n) {
        long[] dp = new long[n];
        long mod = 10000000007l;
        dp[1] =1;
        dp[2] =2;
        dp[3] =4;
        if(n==1)return 1;
        if(n==2)return 2;
        if(n==3)return 4;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return (int)((dp[dp.length-1])%mod);
    }
}
