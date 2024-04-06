package com.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lenOfLastWord(s));
    }

    private static int lenOfLastWord(String s) {
        String[] strArr = s.split("\\s+");
        int n = strArr.length;
        return strArr[n-1].length();
    }
    // with space com O(1)
    private static int lenOfLstWordSpaceOptimized(String s){
        int len = s.length()-1;
        int result =0;
        while (len >=0 && s.charAt(len)==' ')len--;
        while(len >=0 && s.charAt(len)!=' '){
            result++;
            len--;
        }
        return result;
    }
}
