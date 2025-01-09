package com.prep;

public class CountingWordsWithGivenPrefix {
    public static void main(String[] args) {
        String [] words = {"pay","attention","practice","attend"};
        String pref = "at";
        int count = prefixCount(words, pref);
        System.out.println(count);
    }

    private static int prefixCount(String[] words, String pref) {
        int prefixCount =0;
        for(String word:words){
            if(word.startsWith(pref))prefixCount++;
        }
        return prefixCount;
    }
}
