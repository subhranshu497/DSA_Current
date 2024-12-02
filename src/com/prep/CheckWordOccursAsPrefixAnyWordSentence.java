package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CheckWordOccursAsPrefixAnyWordSentence {
    public static void main(String[] args) {
        String sentence = "hello from the other side";
        String searchWord = "they";
        int pos = isPrefixOfWord(sentence, searchWord);
        System.out.println(pos);
    }

    private static int isPrefixOfWord(String sentence, String searchWord) {
        int pos = -1;
        String [] strArr  = sentence.split("\\s+");
        for(int i=0;i< strArr.length;i++){
            int j=0;
            while(j<searchWord.length() && searchWord.length()<= strArr[i].toCharArray().length && strArr[i].charAt(j)==searchWord.charAt(j))
                j++;
            if(j==searchWord.length())return i+1;
        }
        return pos;
    }
}
