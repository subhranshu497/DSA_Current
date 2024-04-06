package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        String s ="ccaabbb";
        System.out.println(lenOfLongestSub(s));
    }

    private static int lenOfLongestSub(String s) {
        int result =0;
        int right =0;
        int left=0;
        Map<Character, Integer> map = new HashMap<>();
        while (right<s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while (map.size()>2){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)map.remove(s.charAt(left));
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}
