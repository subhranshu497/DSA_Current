package com.prep.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target =11;
        int minimumNoOfCoins = coinChangeRec(coins,target, new HashMap<>());
        System.out.println(minimumNoOfCoins);
    }

    private static int minCoinRequiredToGetTarget(int[] coins, int target) {
        int n = coins.length;
        int [] dp = new int[target+1];
        if(target==0)return 0;
        dp[0]=0;
        for(int i=1;i<=target;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int coin :coins){
                if(coin <=i && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        if(dp[target]==Integer.MAX_VALUE) return -1;
        return dp[target];
    }

    //with recursion brute force solution
    public static int coinChangeRec(int[] coins, int amount, Map<Integer, Integer> memo){
        int minCoin =-1;
        if(amount ==0)return 0;
        if (amount<0) return -1;
        if(memo.containsKey(amount)) return memo.get(amount);
        for(int i=0;i<coins.length;i++){
            int subCoin = coinChangeRec(coins,amount-coins[i], memo);
            if(subCoin !=-1){
                int loopCoin = subCoin+1;
                if(loopCoin < minCoin || minCoin==-1){
                    minCoin = loopCoin;
                }
            }
        }
        memo.put(amount, minCoin);
        return minCoin;
    }


















}
