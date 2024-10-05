package com.prep.dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int lcs = lcsDP(s1,s2);
        System.out.println(lcs);
    }

    // using bottom up - DP
    private static int lcsDP(String s1, String s2){
        int m =s1.length();
        int n = s2.length();
        int [][] dp = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                //the case 1 - when char at i == char at j
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    //once we will check i-1 and keep j as constant
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    private static int longCommonSubSeq(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // since there are repeating subprob, so we can memo it
        // the constraint given is 1000, so length is choosen as 1001
        //and we have two variable in the problem , so choose 2d dp
        int [][] memo = new int[1001][1001];
        for(int [] arr :memo){
            Arrays.fill(arr, -1);
        }
        return solveLCS(s1,s2,m,n,0,0, memo);

    }

    private static int solveLCS(String s1, String s2, int m, int n, int i, int j, int [][] memo) {
        //base condition
        if(i>=m || j>=n) return 0;
        if(memo[i][j] !=-1) return memo[i][j];
        //this is the case when match found. So increase the count by 1 and increase each var by 1
        if(s1.charAt(i)==s2.charAt(j)){
            return memo[i][j] =1+solveLCS(s1, s2, m,n, i+1, j+1, memo);
        }
        else{
            //we need to explore two options
            // option 1 - take the first char of s1 and take s2 as is
            // option 2 - take s1 as is and take the first char of s2
            // return the max of both option
            int takeISkipJ = solveLCS(s1,s2, m , n, i+1, j, memo);
            int takeJSkipI = solveLCS(s1, s2, m, n, i,j+1, memo);
            return memo[i][j] = Math.max(takeISkipJ, takeJSkipI);
        }
    }
}
