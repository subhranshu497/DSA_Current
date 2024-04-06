package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s ="eceab";
        int k =2;
        System.out.println(lengthOfLongestSubstringKDistinct(s,k));
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int length=0;
        int right=0;
        int left=0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while(right<n){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left)-1));
                if(map.get(s.charAt(left))==0)map.remove(s.charAt(left));
                left++;
            }
            length = Math.max(length, right-left+1);
            right++;
        }
        return length;
    }
}
