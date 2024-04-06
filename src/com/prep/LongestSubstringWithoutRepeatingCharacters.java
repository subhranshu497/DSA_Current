package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1)return 1;
        int i=0;
        int j=0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            char r = s.charAt(j);
            map.put(r,map.getOrDefault(r,0)+1);
            while(map.get(r)>1){
                char l = s.charAt(i);
                map.put(l, map.get(l)-1);
                i++;
            }
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;
    }
}
