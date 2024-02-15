package com.prep;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    private static String minWindow(String s, String t) {
        if(s.isEmpty() || s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1);
        int start = 0;
        int count =0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        for(int end =0;end < s.length();end++){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)>=0) count++;
            }
            while(count==t.length()){
                if(minLength > end-start+1){
                    minLength = end-start+1;
                    minLeft = start;
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start))>0) count--;
                }
                start++;
            }
        }
        return (minLength>s.length())?"":s.substring(minLeft, minLength+minLeft);
    }
}
