package com.prep;

import java.util.HashMap;
import java.util.Map;

public class TakeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        String s = "abc";
        int k =1;
        int minChar = takeCharacters(s, k);
        System.out.println(minChar);
    }

    private static int takeCharacters(String s, int k) {
        int n = s.length();
        int [] count = new int[3];
        for(char ch:s.toCharArray()){
            if(ch=='a')count[0]++;
            if(ch=='b')count[1]++;
            if(ch=='c')count[2]++;
        }
        //check for count less than k
        if(count[0] <k || count[1] < k || count[2] < k)return -1;
        int left =0;
        int right=0;
        int windowSize =0;
        while(right <n){
            if(s.charAt(right)=='a')count[0]--;
            else if(s.charAt(right)=='b')count[1]--;
            else if(s.charAt(right)=='c')count[2]--;

            while(left <=right && (count[0]<k || count[1]<k || count[2]<k)){
                if(s.charAt(left)=='a')count[0]++;
                else if(s.charAt(left)=='b')count[1]++;
                else if(s.charAt(left)=='c')count[2]++;
                left++;
            }
            windowSize = Math.max(windowSize, right-left+1);
            right++;
        }
        return n-windowSize;
    }
}
