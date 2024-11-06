package com.prep.dynamicProgramming;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        int m = s1.length();
        int n = s2.length();
        //int scss = shortestCommonSupersequenceRecursion(s1, s2);
        String scss = solveSCSSDP(s1, s2, m,n);
       System.out.println(scss);
    }

    //Approcah -1 : REcursion
    private static int shortestCommonSupersequenceRecursion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int [][] memo = new int[m+1][m+1];
        for(int [] arr:memo){
            Arrays.fill(arr, -1);
        }
        //return solveSCSSRecursion(s1, s2, m, n);
        //int scss = solveSCSSMemo(s1, s2, m, n, memo);
        return 0;
    }

    private static String solveSCSSDP(String s1, String s2, int m, int n) {
        int [][] dp = new int [m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)dp[i][j] =i+j;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = 1+Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[m][n]);
        String temp ="";
        int i=m;
        int j = n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                temp +=s1.charAt(i-1);
                i--;
                j--;
            }
            else {
                if(dp[i-1][j] < dp[i][j-1]){
                    temp +=s1.charAt(i-1);
                    i--;
                }
                else {
                    temp +=s2.charAt(j-1);
                    j--;
                }
            }
        }
        //to add remaining character from string s1
        while(i>0){
            temp +=s1.charAt(i-1);
            i--;
        }

        //to add remaining character from string s2
        while(j>0){
            temp +=s2.charAt(j-1);
            j--;
        }
        String scss = "";
        for(int k=temp.length()-1;k>=0;k--){
            scss +=temp.charAt(k);
        }
        return scss;
    }

    private static int solveSCSSMemo(String s1, String s2, int i, int j, int[][] memo) {
        //base condition
        if(i==0 || j==0) memo[i][j] = i+j;
        if(memo[i][j] !=-1)return memo[i][j];
        //match condition
        if(s1.charAt(i-1)==s2.charAt(j-1)){
           return memo[i][j] = 1+solveSCSSMemo(s1,s2,i-1, j-1, memo);
        }
        else{
           return memo[i][j] = 1+Math.min(solveSCSSMemo(s1,s2,i, j-1, memo), solveSCSSMemo(s1,s2,i-1, j, memo));
        }
    }

    private static int solveSCSSRecursion(String s1, String s2, int i, int j) {
        //base condition
        //when one of the string reaches the length 0 , then copy the character of other string
        if(i==0 || j==0) return i+j;
        //match condition :- char of s1 == cahr at s2 , then do one plus rec
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return 1+solveSCSSRecursion(s1, s2, i-1, j-1);
        }
        // otherwise once do i-1 and then j-1, then take the min of both
        else{
            return 1+Math.min(solveSCSSRecursion(s1, s2, i-1, j), solveSCSSRecursion(s1, s2, i, j-1));
        }
    }

    //Approach -2 : Using memoization

}
