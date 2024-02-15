package com.prep;

public class FindFirstPalindromicStringintheArray {
    public static void main(String[] args) {
        String [] words = {"abc","car","ada","racecar","cool"};
        String s = checkFirsPalli(words);
        System.out.println(s);
    }

    private static String checkFirsPalli(String[] words) {
        for(int i=0;i<words.length;i++){
            if(checkPal(words[i])) return words[i];
        }
        return "";
    }
    private static boolean checkPal(String s){
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) !=s.charAt(n-1-i)) return false;
        }
        return true;
    }
}
