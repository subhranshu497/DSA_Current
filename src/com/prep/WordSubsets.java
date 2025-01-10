package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public static void main(String[] args) {
        String [] word1 = {"amazon","apple","facebook","google","leetcode"};
        String [] word2 = {"e","oo"};
        List<String> res = wordSubsets(word1, word2);
        System.out.println(res);
    }

    private static List<String> wordSubsets(String[] word1, String[] word2) {
        List<String> res= new ArrayList<>();
        Map<Character, Integer> wordMap2 = new HashMap<>();
        for (String word : word2) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                wordMap2.put(key, Math.max(wordMap2.getOrDefault(key, 0), value));
            }
        }
        System.out.println(wordMap2);
        //map for word1
        Map<String,Map<Character, Integer>> wordMap1 = new HashMap<>();
        for(String word:word1){
            Map<Character, Integer> innerMap = new HashMap<>();
            for(int i=0;i<word.length();i++){
                innerMap.put(word.charAt(i), innerMap.getOrDefault(word.charAt(i),0)+1);
            }
            wordMap1.put(word, innerMap);
        }
        System.out.println(wordMap1);
        for(int i=0;i<word1.length;i++){
            String s= word1[i];
            Map<Character, Integer> map = wordMap1.get(s);
            boolean flag= true;
            for(Map.Entry<Character, Integer> e:wordMap2.entrySet()){
                char key = e.getKey();
                int val = e.getValue();
                if(!map.containsKey(key)){
                    flag = false;
                    break;
                }
                else{
                    int val1 = map.get(key);
                    if(val1 < val){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                res.add(s);
            }
        }
        return res;
    }
}
