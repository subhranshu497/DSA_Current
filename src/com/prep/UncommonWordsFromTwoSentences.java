package com.prep;

import java.util.*;

public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String [] strArr = uncommonFromSentences(s1,s2);
        for(String s :strArr) System.out.print(s+", ");
    }

    private static String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Arr = s1.split("\\s");
        String[] s2Arr = s2.split("\\s");
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for(String s:s1Arr){
            if(!set2.contains(s)){
                if(set1.contains(s)){
                    set1.remove(s);
                    set2.add(s);
                }
                else set1.add(s);
            }
        }
        for(String s:s2Arr){
            if(!set2.contains(s)){
                if(set1.contains(s)){
                    set1.remove(s);
                    set2.add(s);
                }
                else set1.add(s);
            }
        }
        String [] result = new String[set1.size()];
        int i=0;
        System.out.println("Set1  "+set1);
        System.out.println("Set2  "+set2);
        for(String s:set1){
            result[i] = s;
            i++;
        }
        return result;
    }
}
