package com.prep;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        String s = "ACBBD";
        int min = minLength1(s);
        System.out.println(min);
    }

    private static int minLength1(String s) {
        if(s.length()==1) return 1;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(st.empty()){
                st.push(c);
                continue;
            }
            else if(c=='B' && st.peek()=='A')st.pop();
            else if(c=='D' && st.peek()=='C')st.pop();
            else st.push(c);
        }
        return st.size();
    }
}
