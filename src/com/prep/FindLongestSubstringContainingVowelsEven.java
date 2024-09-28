package com.prep;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringContainingVowelsEven {
    public static void main(String[] args) {
        String s= "eleetminicoworoep";
        int result = findTheLongestSubstring(s);
        System.out.println(result);
    }

    private static int findTheLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int [] state = new int[5];
        int result =0;
        String currentState = "00000";
        map.put(currentState, -1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') state[0] = (state[0] ^ 1);
            else if(s.charAt(i)=='e') state[1] = (state[1] ^ 1);
            else if(s.charAt(i)=='i') state[2] = (state[2] ^1);
            else if(s.charAt(i)=='o') state[3] = (state[3] ^1);
            else if(s.charAt(i)=='u') state[4] = (state[4] ^1);
            String current ="";
            for(int j=0;j<5;j++){
                current +=state[j];
            }
            if(map.containsKey(current)){
                result = Math.max(result, i-map.get(current));
            }
            else{
                map.put(current, i);
            }
        }
        return result;
    }
}
