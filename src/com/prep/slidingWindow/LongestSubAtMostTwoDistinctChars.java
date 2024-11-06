package com.prep.slidingWindow;

import java.util.*;

public class LongestSubAtMostTwoDistinctChars {
    public static void main(String[] args) {
        String s = "eceba";
        int len = lenLongestSubWithTwoDistinctChars(s);
        System.out.println(len);
    }

    private static int lenLongestSubWithTwoDistinctChars(String s) {
        int ans = 0;
        int n = s.length();
        int left = 0, right =0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < n){
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar,0)+1);
            while(map.size()>2){
                char lChar = s.charAt(left);
                map.put(lChar, map.getOrDefault(lChar,0)-1);
                if(map.get(lChar)==0) map.remove(lChar);
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }

        return ans;
    }
}
