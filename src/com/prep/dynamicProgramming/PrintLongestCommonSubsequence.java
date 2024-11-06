package com.prep.dynamicProgramming;

import java.util.Map;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        String result = printLCS(s1, s2);
        System.out.println(result);
    }

    private static String printLCS(String s1, String s2) {
        //find the longest common subsequence
        int m = s1.length();
        int n = s2.length();
        int [][] dp = new int[m+1][n+1];
        for(int i =0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) dp[i][j] =0;
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcsLen = dp[m][n];
        System.out.println(lcsLen);
        String temp ="";
        // to construct the lcs
        int i=m;
        int j=n;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                temp +=s1.charAt(i-1);
                i--;
                j--;
            }else {
                if (dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else j--;
            }
        }
        //now we got the string , but it is in reverse order . so reverse it
        String lcs = "";
        for(int k=temp.length()-1;k>=0;k--){
            lcs +=temp.charAt(k);
        }
        return lcs;
    }
}
