package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        String [] words={"mass","as","hero","superhero"};
        List<String> res = stringMatching(words);
        System.out.println(res);
    }

    private static List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            String word = words[i];
            for(int j=0;j<n;j++){
                if(j==i)
                    continue;
                String word1 = words[j];
                if(word.length() < word1.length()){
                    if(word1.contains(word))set.add(word);
                    else{
                        if(word.contains(word1))set.add(word1);
                    }
                }
            }
        }
        for(String s:set)
            res.add(s);
        return res;
    }
}
