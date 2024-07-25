package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String [] words={"bella","label", "roller"};
        List<String> result = findCommonChar(words);
    }

    private static List<String> findCommonChar(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        Map<Integer,List<Character>> map = new HashMap<>();
        for(String s:words){
            List<Character> charList = new ArrayList<>();
            for(int i=0;i<s.length();i++){
               // map.put(i,charList.add(s.charAt(i)));
            }
        }
        System.out.println(map);
        return result;
    }
}
