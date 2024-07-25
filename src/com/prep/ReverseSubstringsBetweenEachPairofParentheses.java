package com.prep;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    public static void main(String[] args) {
        String s = "(i(love)u)";
        String result = reverseParentheses(s);
        System.out.println(result);
    }

    private static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {

            }
        }
        return sb.toString();
    }
    private static String revStr(StringBuilder sb, int start, int end){

        return "hi";
    }
}
