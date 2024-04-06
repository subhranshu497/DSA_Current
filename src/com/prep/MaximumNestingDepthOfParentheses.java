package com.prep;

import java.util.Stack;

public class MaximumNestingDepthOfParentheses {
    public static void main(String[] args) {
        String s ="(1)+((2))+(((3)))";
        System.out.println(maxDepthParenthesis(s));
    }

    private static int maxDepthParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        int max = 0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='(')st.push(s.charAt(i));
            if(s.charAt(i)==')'){
                if(st.peek()=='('){
                    st.pop();
                }
            }
            max = Math.max(max, st.size());
            i++;
        }
        return  max;
    }
}
