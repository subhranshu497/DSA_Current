package com.prep;

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public static void main(String[] args) {
        String s = "]]][[[";
        int count = minSwaps1(s);
        System.out.println(count);
    }

    private static int minSwaps1(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='[') st.push(c);
            else {
                if(!st.isEmpty() && st.peek()=='[')st.pop();
                else st.push(c);
            }
        }
        int ans = st.size()/2;
        return (ans+1)/2;
    }
}
