package com.prep.meta;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word = "apple";
        String abbr = "a2e";
        boolean flag = validWordAbbreviation(word, abbr);
        System.out.println(flag);
    }

    private static boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        int j=0;
        if(abbr.equals(word.length()+"") || word.equals(abbr)) return true;
        while(i<word.length() && j<abbr.length()){
            if(word.charAt(i)==abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(abbr.charAt(j)<='0' || abbr.charAt(j)>'9') return false;
            int start = j;
            while(j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9')j++;
            int num = Integer.parseInt(abbr.substring(start, j));
            i +=num;
        }
        return i==word.length() && j==abbr.length();
    }
}
