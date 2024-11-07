package com.prep.hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingStringsArrays {
    public static void main(String[] args) {
        List<String> stringList = List.of("ab","ab","abc");
        List<String> queries = List.of("ab","abc","bc");
        List<Integer> result = matchingStrings(stringList, queries);
        System.out.println(result);
    }

    private static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> map = new HashMap<>();
        for(String key: stringList){
            map.put(key, map.getOrDefault(key,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        for(String str:queries){
            if(map.containsKey(str)){
                int val = map.get(str);
                result.add(val);
            }
            else result.add(0);
        }
        return result;
    }
}
