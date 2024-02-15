package com.prep.hackerRank;

public class JavaStringIntroduction {
    public static void main(String[] args) {
        String A = "kiana";
        String B = "aarya";
        strIntro(A,B);
    }

    private static void strIntro(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int sum = len1+len2;
        int s1 = a.charAt(0);
        int s2 = b.charAt(0);
        String op = s1>s2?"No":"Yes";
        String sub1 = a.substring(0,1).toUpperCase();
        String sub2 = b.substring(0,1).toUpperCase();
        String rem1 = a.substring(1,len1);
        String rem2 = b.substring(1,len2);
        String result = sub1+rem1+" "+sub2+rem2;
        System.out.println();
    }
}
