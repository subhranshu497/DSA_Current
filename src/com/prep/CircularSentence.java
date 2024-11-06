package com.prep;

public class CircularSentence {
    public static void main(String[] args) {
        String sentence = "Leetcode is cool";
        System.out.println(isCircularSentence(sentence));
    }

    private static boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1))
            return false;
        int space = sentence.indexOf(" ");
        if(space==-1)
            return true;
        while(space != -1){
            if(sentence.charAt(space-1) != sentence.charAt(space+1))
                return false;
            space = sentence.indexOf(space+1);
        }
        return true;
    }
}
