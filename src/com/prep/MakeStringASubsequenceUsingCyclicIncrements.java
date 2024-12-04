package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeStringASubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "d";
        boolean flag = canMakeSubsequence(str1, str2);
        System.out.println(flag);
    }

    private static boolean canMakeSubsequence(String str1, String str2) {
        int str2Len = str2.length();
        int idx = 0;
        for(char ch:str1.toCharArray()){
            if(idx < str2Len && (str2.charAt(idx)-ch+26) % 26 <= 1)
                idx++;
        }
        return idx==str2Len?true:false;
    }
}
