package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> map = new HashMap<>();
       if(s.length()==1)return 1;
       int left = 0;
       int right=0;
       int ans =0;
       while(right<s.length()){
           char rch = s.charAt(right);
           map.put(rch, map.getOrDefault(rch,0)+1);
           while(map.get(rch)>1){
               char lch = s.charAt(left);
               map.put(lch, map.get(lch)-1);
               left++;
           }
           ans = Math.max(ans,right-left+1);
           right++;
       }
       return ans;
    }
}
