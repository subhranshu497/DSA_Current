package com.prep.amazonSpring;

import java.util.Locale;

public class OptimalPartitionOfString {
    public static void main(String[] args) {
        String s = "abacaba";
        int op= partitionString(s);
    }

    private static int partitionString(String s) {
        int[] count = new int[26];
        for(int i=0;i<26;i++)count[i] =-1;
        int optimalCount = 0;
        int startIndex =0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(count[curr-'a'] >=startIndex){
                optimalCount++;
                startIndex =i;
            }
            count[curr-'a']=i;
        }
        return optimalCount+1;
    }
}
