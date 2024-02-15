package com.prep;

import java.sql.SQLOutput;
import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams {
    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        List<String> result = removeAnagrams(words);
        System.out.println(result);
    }

    private static List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            char[] chArr = words[i].toCharArray();
            Arrays.sort(chArr);
            String s = String.valueOf(chArr);
            list.add(s);
        }
        System.out.println("Sorted list    "+list);
        List<Integer> indicesList = new ArrayList<>();
        indicesList.add(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i-1).equals(list.get(i))){
                continue;
            }
            else indicesList.add(i);
        }
        System.out.println("   indices  "+indicesList);
        List<String> result = new ArrayList<>();
        for(int i: indicesList){
            result.add(words[i]);
        }
        return result ;
    }
}
