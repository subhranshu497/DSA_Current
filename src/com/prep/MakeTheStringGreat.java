package com.prep;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }

    private static String makeGood(String s) {
        int right  =0;
        int n = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(right<n){
            int newRight = right+1;
            char ch1= sb.charAt(right);
            char ch2= sb.charAt(newRight);
            int diff = Math.abs(ch1-ch2);
            if(diff==32){
                sb.deleteCharAt(newRight);
                sb.deleteCharAt(right);
                right =0;
                n -=2;
            }
            else right++;
        }
        return sb.toString();
    }
}
