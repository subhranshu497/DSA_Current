package com.prep.dynamicProgramming;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target =3;
        int minimumNoOfCoins = coinChangeRec(coins,target);
        System.out.println(minimumNoOfCoins);
    }

    private static int coinChangeRec(int[] coins, int target) {
        int [][] memo = new int[coins.length+1][target+1];
        for(int [] m:memo) Arrays.fill(m,-1);
        return solveCoinChange(0,coins, target, memo);
    }

    private static int solveCoinChange(int i, int[] coins, int target, int [][] memo) {
        //base condition
        if(target == 0){
            return 1;
        }
        if(i >=coins.length) return 0;
        if(memo[i][target] != -1) return memo[i][target];
        if(coins[i]>target){
            return memo[i][target] = solveCoinChange(i+1,coins,target, memo);
        }
        int take= solveCoinChange(i,coins, target-coins[i],memo);
        int skip = solveCoinChange(i+1,coins,target, memo);
        return memo[i][target] = take+skip;
    }


}
