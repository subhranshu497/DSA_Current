package com.prep;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = "(((";
        int move = minAddToMakeValid(s);
        System.out.println(move);
    }

    private static int minAddToMakeValid(String s) {
        if(s.length() == 1)return 1;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.isEmpty() || ch=='('){
                st.push(ch);
            }
            else if(ch == ')' && st.peek()=='('){
                st.pop();
            }
        }
        return st.size();
    }
}
