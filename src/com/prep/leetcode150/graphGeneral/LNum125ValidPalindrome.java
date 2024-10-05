package com.prep.leetcode150.graphGeneral;

public class LNum125ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))sb.append(s.charAt(i));
        }
        String s1 = sb.toString().toLowerCase();
        int j = s1.length()-1;
        int i=0;
        while(i<j){
            if(s1.charAt(i) !=s1.charAt(j)) return false;
            j--;
            i++;
        }
        return true;
    }
}
