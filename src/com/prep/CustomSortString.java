package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "kqep";
        String s = "pekeq";
        System.out.println(customSortString(order,s));
    }

    private static String customSortString(String order, String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        for(char ch:order.toCharArray()){
            if(freqMap.containsKey(ch)) {
                while (freqMap.get(ch)>0){
                    sb.append(ch);
                    freqMap.put(ch, freqMap.get(ch)-1);
                }
            }
        }
        for(char ch:freqMap.keySet()){
            if(freqMap.get(ch)>0)sb.append(ch);
        }
        return sb.toString();
    }
}
