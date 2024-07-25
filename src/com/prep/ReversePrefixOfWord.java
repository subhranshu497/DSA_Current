package com.prep;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch='d';
        System.out.println(reversePrefix(word,ch));
    }

    private static String reversePrefix(String word, char ch) {
        int end=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                end=i;
                break;
            }
        }
        int start=0;
        char[] charArr = word.toCharArray();
        while(start <=end){
            char temp =charArr[start];
            charArr[start] = charArr[end];
            charArr[end] =temp;
            start++;
            end--;
        }
        return String.valueOf(charArr);
    }
}
