package com.prep;

public class CountPalindromicSubsequences {
    public static void main(String[] args) {
        String s = "103301";
        System.out.println(countPalindromes(s));
    }

    private static int countPalindromes(String s) {
        int count =0;
        int i=0;
        int n = s.length();
        while (i<n ){
            String sub = s.substring(i,i+4);
            if(checkPallindrome(sub))count++;
        }
        return 0;
    }
    private static boolean checkPallindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
