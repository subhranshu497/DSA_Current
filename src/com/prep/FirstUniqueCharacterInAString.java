package com.prep;

import java.util.*;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqCharAlt(s));
    }

    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result =-1;
        Set<Character> set = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
                set.add(ch);
            }
            else{
                set.remove(ch);
            }
        }
        for(char c:set){
           result= map.get(c);
           break;
        }
        return result;
    }
    private static int firstUniqCharAlt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}
