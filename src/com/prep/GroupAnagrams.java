package com.prep;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> results = groupAnagrams(strs);
        System.out.println(results);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for(String str:strs){
            List<Integer> innerList = new ArrayList<>();
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            if(!strMap.containsKey(key)) strMap.put(key, new ArrayList<>());
            strMap.get(key).add(str);
        }
        return new ArrayList<>(strMap.values());
    }
}
