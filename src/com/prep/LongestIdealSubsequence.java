package com.prep;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        String s = "abcd";
        int k =3;
        System.out.println(longestIdealString(s,k));
    }

    private static int longestIdealString(String s, int k) {
        int [] dp = new int[26];
        int result =0;
        for(int i=0;i<s.length();i++){
            int current = s.charAt(i) - 'a';
            int temp =0;
            for(int prev=0;prev<26;prev++){
                if(Math.abs(prev-current)<=k) temp = Math.max(temp,dp[prev]);
            }
            dp[current] = Math.max(dp[current],temp+1);
            result = Math.max(result,dp[current]);
        }
        return result;
    }
}
