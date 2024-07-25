package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s ="abccccdd";
        int len= longestPalindromeLength(s);
        System.out.println(len);
    }

    private static int longestPalindromeLength(String s) {
        int len =0;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);
        boolean flag = false;
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            char ch = e.getKey();
            int val = e.getValue();
            if(val%2==0) len +=val;
            else {
                int res = val/2;
                len +=res;
                flag = true;
            }
        }

        return flag==true?len+1:len;
    }
}
