package com.prep.hackerRank;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    public static void main(String[] args) {
        String s = "and";
        String t = "art";
        System.out.println(checker(s,t));

    }

    private static String checker(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c:s.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        for(char ch:t.toCharArray()){
            if(freqMap.containsKey(ch)) return "YES";
        }
        return "NO";
    }
}
