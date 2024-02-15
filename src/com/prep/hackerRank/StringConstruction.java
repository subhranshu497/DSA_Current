package com.prep.hackerRank;

import java.util.HashSet;
import java.util.Set;

public class StringConstruction {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(stringCon(s));
    }

    private static int stringCon(String s) {
        int cost =0;
        Set<Character> uniqueChar = new HashSet<>();
        for(char ch:s.toCharArray()){
            if(!uniqueChar.contains(ch)){
                cost++;
                uniqueChar.add(ch);
            }
        }
        return cost;
    }
}
