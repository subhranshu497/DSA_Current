package com.prep.dynamicProgramming;

import java.util.Arrays;

public class LongestStringChain {
    public static void main(String[] args) {
        String [] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        //int longestChain = longestChain(words);
        int longestChain = longestChainUsingDP(words);
        System.out.println(longestChain);
    }

    private static int longestChainUsingDP(String[] words) {
        int n = words.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        Arrays.sort(words, (a,b)->a.length()-b.length());
        for(int i=0;i<n;i++){
            int j =0;
            while(j<i){
                if(checkPredecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
                j++;
            }
        }
        return maxLen;
    }

    private static int longestChain(String[] words) {
        int n = words.length;
        int [][] memo = new int[n][n];
        for(int [] arr:memo){
            Arrays.fill(arr, -1);
        }
        Arrays.sort(words, (a,b)->a.length()-b.length());
        return longestChainMemo(words, n, -1, 0, memo);
    }

    private static int longestChainMemo(String[] words, int n, int prev, int curr, int [][] memo) {
        //base condition
        if(curr >= n) return 0;
        if(prev !=-1 && memo[prev][curr] != -1) return memo[prev][curr];
        int take=0;
        if(prev ==-1 || checkPredecessor(words[prev], words[curr])){
            take = 1+longestChainMemo(words, n, curr, curr+1, memo);
        }
        int skip = longestChainMemo(words, n, prev, curr+1, memo);
        if(prev !=-1)memo[prev][curr] = Math.max(take, skip);
        return Math.max(take, skip);
    }

    private static boolean checkPredecessor(String prev, String curr) {
        int m = prev.length();
        int n = curr.length();
        if(m>=n || n-m !=1) return false;
        int i =0;
        int j=0;
        while(i<m && j<n){
            if(prev.charAt(i)==curr.charAt(j))i++;
            j++;
        }
        return i==m;
    }
}
