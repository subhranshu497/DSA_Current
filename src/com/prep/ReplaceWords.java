package com.prep;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public static void main(String[] args) {
        String sentence = "the cattle was rattled by the battery";
        List<String> dictionary = List.of("cat","bat","rat");
        String result = replaceWordsFn(dictionary, sentence);
        System.out.println(result);
    }

    private static String replaceWordsFn(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] wordArr = sentence.split(" ");
        for(int i=0;i< wordArr.length;i++) wordArr[i] = calculateShortestWord(wordArr[i],set);
        return String.join(" ",wordArr);
    }

    private static String calculateShortestWord(String word, Set<String> set) {
        for(int i=1;i<word.length();i++){
            String s= word.substring(0,i);
            if(set.contains(s)) return s;
        }
        return word;
    }
}
