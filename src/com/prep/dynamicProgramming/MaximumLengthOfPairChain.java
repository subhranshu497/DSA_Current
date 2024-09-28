package com.prep.dynamicProgramming;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int [][] pairs = {{1,2},{7,8},{4,5}};
        //int longestChain = findLongestChain(pairs);
        int longestChain = findLongestChainDP(pairs);
        System.out.println(longestChain);
    }

    private static int findLongestChainDP(int[][] pairs) {
        // sort the array
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        int [] dp = new int[pairs.length+1];
        Arrays.fill(dp, 1);
        for(int curr=0;curr< pairs.length;curr++){
            for(int prev=0;prev<curr;prev++){
                if(pairs[prev][1]< pairs[curr][0]){
                    dp[curr] = Math.max(dp[curr], dp[prev]+1);
                }
            }
        }
        // to find max
        int max = 0;
        for(int num:dp) max = Math.max(num, max);
        return max;
    }

    private static int findLongestChain(int[][] pairs) {
        int [][] memo = new int[pairs.length+1][pairs.length+1];
        // fill it with -1;
        for(int [] arr :memo) Arrays.fill(arr, -1);
        //first sort the array
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);

        return findLongestChainMemo(pairs,0, -1, memo);
    }

    private static int findLongestChainMemo(int[][] pairs, int current, int prev, int [][] memo) {
        //base condition
        if(current >= pairs.length) return 0;
        //here are two options take and skip
        //in case of take = 1+ recursion
        //in case of skip , recursion
        // condition to be checked in case of take pairs[curr][0] > pairs[prev][0]
        if(prev != -1 && memo[prev][current] !=-1) return memo[prev][current];
        int take =0;
        if(prev == -1 || pairs[current][0]>pairs[prev][1]){
            take = 1+findLongestChainMemo(pairs, current+1, current, memo);
        }
        int skip = findLongestChainMemo(pairs, current+1, prev, memo);

        if(prev != -1) memo[prev][current] = Math.max(take, skip);
        return Math.max(take, skip);
    }

}
