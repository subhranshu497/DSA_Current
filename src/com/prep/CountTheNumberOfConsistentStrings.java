package com.prep;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        String allowed = "ab";
        String [] words ={"ad", "bd","aaab","baa","badab"};
        int count = countConsistentStrings(allowed, words);
        System.out.println(count);
    }

    private static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        char[] allowedArr = allowed.toCharArray();
        for(char ch:allowedArr){
            set.add(ch);
        }
        int count = 0;
        for(String word:words){
            boolean flag = true;
            for(int i=0;i<word.length();i++){
                if(!set.contains(word.charAt(i))){
                    flag =false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}
