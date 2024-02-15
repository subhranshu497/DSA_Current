package com.prep;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDup(s));
    }

    private static String removeDup(String s) {
        Map<Character, Integer> lastOccerances = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            lastOccerances.put(s.charAt(i), i);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!seen.contains(ch)){
                while(!stack.isEmpty() && ch<stack.peek() && lastOccerances.get(stack.peek())>i){
                    char c = stack.pop();
                    seen.remove(c);
                }
                stack.push(ch);
                seen.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
