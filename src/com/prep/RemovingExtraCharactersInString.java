package com.prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemovingExtraCharactersInString {
    public static void main(String[] args) {
        String s = "leetscode";
        String [] dict = {"leet", "code", "leetcode"};
        int count = minExtraChar(s, dict);
        System.out.println(count);
    }

    private static int minExtraChar(String s, String[] dict) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        for(String str :dict)set.add(str);

        return minXCharMemo(0,n, set, s, memo);
    }

    private static int minXCharMemo(int i, int n, Set<String> set, String s, int[] memo) {
        //base condtion
        if(i>=n) return 0;
        if(memo[i] !=-1) return memo[i];
        int result = 1+minXCharMemo(i+1, n, set, s, memo);
        for(int j=i;j<n;j++){
            String curr = s.substring(i, j+1);
            if(set.contains(curr)){
                result = Math.min(result, minXCharMemo(j+1, n, set, s, memo));
            }
        }
        return memo[i] = result;
    }
}
