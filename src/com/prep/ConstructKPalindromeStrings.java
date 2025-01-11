package com.prep;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        String s = "qlkzenwmmnpkopu";
        int k = 15;
        boolean flag = canConstruct(s,k);
        System.out.println(flag);
    }

    private static boolean canConstruct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(s.length());
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int oddFreqCount =0;
        for(Map.Entry<Character, Integer> e:map.entrySet()){
            if(e.getValue() % 2 !=0){
                oddFreqCount++;
            }
        }
        if(oddFreqCount <= k && k <=s.length())
            return true;

        return false;
    }
}
