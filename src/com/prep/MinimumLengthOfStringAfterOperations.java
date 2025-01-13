package com.prep;

import java.util.*;

public class MinimumLengthOfStringAfterOperations {
    public static void main(String[] args) {
        String s = "ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj";
        int len = minimumLength(s);
        System.out.println(len);
    }

    private static int minimumLength(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        System.out.println(freqMap.size());
        System.out.println(freqMap);
        int count =0;
        for(Map.Entry<Character, Integer> e:freqMap.entrySet()){
            int val = e.getValue();
            while(val >= 3){
                val -=2;
            }
            count +=val;
        }
        return count;
    }
}
