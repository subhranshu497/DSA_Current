package com.prep;

public class SubstringsThatBeginAndEndWithSameLetter {
    public static void main(String[] args) {
        String s = "abacad";
        long substringCount = numberOfSubstring(s);
        System.out.println(substringCount);
    }

    private static long numberOfSubstring(String s) {
        long count=0;
        int[] prefixCount = new int[26];
        for(int i=0;i<s.length();i++){
            prefixCount[s.charAt(i)-'a']++;
            count +=prefixCount[s.charAt(i)-'a'];
        }
        return count;
    }
}
