package com.prep;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        String s = "aabca";
        int paliCount = countPalindromicSubsequence(s);
        System.out.println(paliCount);
    }

    private static int countPalindromicSubsequence(String s) {
        int n = s.length();

        Set<Character> setChar = new HashSet<>();
        for(int i=0;i<n;i++){
            setChar.add(s.charAt(i));
        }
        int result = 0;
        for(char ch:setChar){
            int leftIdx =-1;
            int rightIdx = -1;
            for(int i=0;i<n;i++){
                if(s.charAt(i)==ch){
                    if(leftIdx ==-1)
                        leftIdx =i;
                    rightIdx =i;
                }
            }
            Set<Character> setCharToCheckMiddle = new HashSet<>();
            for(int mid =leftIdx+1;mid<=rightIdx-1;mid++){
                setCharToCheckMiddle.add(s.charAt(mid));
            }
            result +=setCharToCheckMiddle.size();
        }
        return result;
    }

}
