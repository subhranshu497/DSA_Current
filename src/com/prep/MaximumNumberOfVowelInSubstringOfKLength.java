package com.prep;

import java.util.Set;

public class MaximumNumberOfVowelInSubstringOfKLength {
    public static void main(String[] args) {
        String s = "weallloveyou";
        int k = 7;
        System.out.println(maxVowels(s,k));
    }

    private static int maxVowels(String s, int k) {
        int count =0;
        Set<Character> vowels = Set.of('a','e','i','o','u');
        for(int i=0;i<k;i++){
            count += vowels.contains(s.charAt(i))?1:0;
        }
        int result =count;
        for(int i=k;i<s.length();i++){
            count +=vowels.contains(s.charAt(i))?1:0;
            count -=vowels.contains(s.charAt(i-k))?1:0;
            result = Math.max(result, count);
        }
        return result;
    }
    private static boolean isVowel(char c){
        if(c =='a'||c=='e'||c=='i'||c=='o'||c=='u')return true;

        return false;
    }
}
