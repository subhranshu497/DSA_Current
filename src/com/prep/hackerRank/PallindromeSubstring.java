package com.prep.hackerRank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Sherlock and anagram
 */
public class PallindromeSubstring {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(findAnagram(s));
    }

    private static int findAnagram(String s) {
        int count = 0;
        Map<String, Integer> anaCount = new HashMap<>();
        int len=1;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                char[] chArr = s.substring(i,j+1).toCharArray();
                Arrays.sort(chArr);
                String sorted = String.valueOf(chArr);
                anaCount.put(sorted, anaCount.getOrDefault(sorted,0)+1);
            }
        }
        for(int val : anaCount.values()){
            count += (val*(val-1))/2;
        }
        return count;
    }
}

