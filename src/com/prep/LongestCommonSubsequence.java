package com.prep;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(lcs(text1, text2));
    }

    private static int lcs(String text1, String text2) {
        int count =0;
        int len =text1.length()<text2.length()?text1.length():text2.length();
        int j=0;
        for(int i=0;i<len;i++){
            if(text1.charAt(i)==text2.charAt(j)){
                count++;
                j++;
            }
        }
        return count;
    }
}
