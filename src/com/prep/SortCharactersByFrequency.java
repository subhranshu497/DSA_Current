package com.prep;

import java.util.*;

public class SortCharactersByFrequency {
    static class Pair{
        int count;
        char ch;
        public Pair(int count, char ch){
            this.count = count;
            this.ch = ch;
        }
    }
    public static void main(String[] args) {
        String s = "tree";
        String t= frequencySort(s);
        System.out.println(t);
    }

    private static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: s.toCharArray()) freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        List<Character>list = new ArrayList<>(freqMap.keySet());
        Collections.sort(list, (a,b)->freqMap.get(b)-freqMap.get(a));
        StringBuilder sb = new StringBuilder();
        for(char ch:list){
            int val = freqMap.get(ch);
            for(int i=0;i<val;i++)sb.append(ch);
        }
        return sb.toString();
    }
}
