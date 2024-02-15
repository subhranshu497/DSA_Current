package com.prep;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));

    }

    private static int countSubstrings(String s) {
        int count =0;
        for(int i=0;i<s.length();i++){
            int left =i;
            int right =i;
            while (left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
            left =i;
            right=i+1;
            while (left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
    private static boolean checkPallindrome(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return s.equals(sb.toString());
    }
}
