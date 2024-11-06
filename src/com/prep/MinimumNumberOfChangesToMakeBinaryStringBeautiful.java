package com.prep;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    public static void main(String[] args) {
        String s = "1001";
        int changes = minChanges(s);
        System.out.println(changes);
    }

    private static int minChanges(String s) {
        int n = s.length();
        int changes = 0;
        for(int i=0;i<n-1;i +=2){
            if(s.charAt(i) !=s.charAt(i+1))changes++;
        }
        return changes;
    }
}
