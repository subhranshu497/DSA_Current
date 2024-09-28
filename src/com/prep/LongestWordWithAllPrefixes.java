package com.prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        String [] words = {"abc", "bc", "ab", "qwe"};
        String word = longestWord(words);
        System.out.println(word);
    }

    private static String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        Set<String> set = new HashSet<>();
        for(String s:words){
            set.add(s);
        }
        for(int i= words.length-1;i>=0;i--){
            String tempWord = words[i];
            int n = tempWord.length();
            boolean flag = false;
            //form the prefix array
            for(int j=1;j<=n;j++){
                String subStr = tempWord.substring(0,j);
                if(!set.contains(subStr)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                result = tempWord;
                break;
            }
        }
        return result;
    }
}
