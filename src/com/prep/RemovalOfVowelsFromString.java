package com.prep;

import java.util.HashSet;
import java.util.Set;

public class RemovalOfVowelsFromString {
    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(removeVowels(s));
    }

    private static String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(char ch: s.toCharArray()){
            if(!set.contains(ch))sb.append(ch);
        }
        return sb.toString();
    }
}
