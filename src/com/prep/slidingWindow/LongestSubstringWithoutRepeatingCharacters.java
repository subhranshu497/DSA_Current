package com.prep.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        int len = lenOfLongestSubstring(s);
        System.out.println(len);
    }

    private static int lenOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans =0;
        if(n==0) return 0;
        if(n==1) return 1;
        int l=0, r= 0;
        while (r<n && l<n){
            char rChar = s.charAt(r);
            while(!set.add(rChar)){
                char lChar = s.charAt(l);
                set.remove(lChar);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
