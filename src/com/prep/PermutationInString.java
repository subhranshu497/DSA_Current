package com.prep;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }

    private static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)return false;
        char[] cArr1 = s1.toCharArray();
        Arrays.sort(cArr1);
        int i=0;
        while(i<=n2-n1){
            String sub = s2.substring(i,i+n1);
            char [] cArr2 = sub.toCharArray();
            Arrays.sort(cArr2);
            if(Arrays.equals(cArr1,cArr2)) return true;
            i++;
        }
        return false;
    }
}
