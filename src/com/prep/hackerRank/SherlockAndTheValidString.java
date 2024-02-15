package com.prep.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndTheValidString {
    public static void main(String[] args) {
        String s = "aabbcd";
        System.out.println(isValidString(s));
    }

    private static String isValidString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        if(s.length()==1) return "YES";
        for(char ch:s.toCharArray()) freq.put(ch, freq.getOrDefault(ch,0)+1);
        int [] freqArr = new int[freq.size()];
        int i=0;
        for(Map.Entry<Character,Integer> e:freq.entrySet()){
            freqArr[i++]=e.getValue();
        }
        Arrays.sort(freqArr);
        int first = freqArr[0];
        int second = freqArr[1];
        int last = freqArr[freqArr.length-1];
        int secondLast = freqArr[freqArr.length-2];
        if(first==last) return "YES";
        if(first==1 && second==last) return "YES";
        if(first==second && second==secondLast && secondLast==(last-1))return "YES";
        return "NO";
    }
}
