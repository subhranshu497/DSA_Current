package com.prep;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagram {
    public static void main(String[] args) {
        String b ="fcrxzwscanmligyxyvym";
        String a ="jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(mAnagram(a,b));
    }

    private static int mAnagram(String a, String b) {
        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();
        int count =0;
        for(char ch:a.toCharArray()){
            freqMap1.put(ch,freqMap1.getOrDefault(ch,0)+1);
        }
        for(char ch:b.toCharArray()){
            freqMap2.put(ch,freqMap2.getOrDefault(ch,0)+1);
        }
        for(char ch:freqMap1.keySet()){
            if(freqMap2.containsKey(ch)){
                int v1 = freqMap1.get(ch);
                int v2 = freqMap2.get(ch);
                count +=Math.abs(v1-v2);
            }
        }
        for(char ch:b.toCharArray()){
            if(!freqMap1.containsKey(ch))count++;
        }
        for(char ch:a.toCharArray()){
            if(!freqMap2.containsKey(ch))count++;
        }
        return count;
    }
}
