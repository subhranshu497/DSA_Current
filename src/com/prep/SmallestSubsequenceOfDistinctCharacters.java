package com.prep;

import java.util.*;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        String s= "cbacdcbc";
        System.out.println(smallestSubsequence(s));
    }

    private static String smallestSubsequence(String s) {
        Map<Character, Integer> lastOccerance = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        for(int i=0;i<s.length();i++){
            lastOccerance.put(s.charAt(i),i);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!seen.contains(ch)){
                while(!stack.isEmpty() && ch<stack.peek() && lastOccerance.get(stack.peek())>i){
                    seen.remove(stack.peek());
                    stack.pop();
                }
                stack.push(ch);
                seen.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
