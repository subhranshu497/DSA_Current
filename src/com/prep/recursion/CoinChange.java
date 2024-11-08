package com.prep.recursion;

import java.util.Arrays;

public class CoinChange {
    private static int result=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] coins = {1};
        int amount =11;
        int changes = coinchg(coins, amount);
        System.out.println(changes);
    }

    private static int coinchg(int[] coins, int amount) {
        int n = coins.length;
        int [] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int minCoin =-1;
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    dp[i]= Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        minCoin = dp[amount];
        return minCoin;
    }
}
