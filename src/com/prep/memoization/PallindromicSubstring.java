package com.prep.memoization;

import java.util.Arrays;

public class PallindromicSubstring {
    public static void main(String[] args) {
        String s = "aaa";
        int count = countSubstrings1(s);
        System.out.println(count);
    }

    private static int countSubstrings1(String s) {
        int [][] memo = new int[1001][1001];
        for(int [] arr: memo) Arrays.fill(arr, -1);
        int n = s.length();
        int count =0;
        for(int i=0;i<n;i++){
            for(int j =i;j<n;j++){
                int temp = checkPalli(s, i, j, memo);
                if(temp==1) count++;
            }
        }
        return count;
    }

    private static int checkPalli(String sub, int i, int j, int [][] memo) {
        //base condition
        if(i>j){
            return 1;
        }
        if(memo[i][j] !=-1) return memo[i][j];
        if(sub.charAt(i)==sub.charAt(j)){
            return memo[i][j] =checkPalli(sub, i+1, j-1, memo);
        }
        return 0;
    }
}
