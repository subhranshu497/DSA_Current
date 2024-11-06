package com.prep.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String pat = "for";
        int size = search2(text, pat);
        System.out.println(size);
    }

    private static int search2(String text, String pat) {
        int n = text.length();
        int k = pat.length();
        int j=0;
        int i=0;
        int ans =0;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : pat.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        while(j<n){
            map.put(text.charAt(j), map.getOrDefault(text.charAt(j),0)-1);
            if(j-i+1 == k){
                if(allZeros(map)){
                    ans++;
                }
                char left = text.charAt(i);
                map.put(left, map.getOrDefault(left,0)+1);
                i++;
            }
            j++;
        }
        return ans;
    }

    private static boolean allZeros(Map<Character, Integer> map) {
        for(int val:map.values()){
            if(val !=0) return false;
        }
        return true;
    }
}
