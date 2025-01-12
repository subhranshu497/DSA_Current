package com.prep;

import java.util.Stack;

public class CheckIfParenthesesStringCanBeValid {
    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";
        boolean flag = canBeValid(s,locked);
        System.out.println(flag);
    }

    private static boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 !=0) return false;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'){
                openClose.push(i);
            } else if(s.charAt(i)=='('){
                open.push(i);
            } else if(s.charAt(i)==')'){
                if(!open.isEmpty()) open.pop();
                else if(!openClose.isEmpty())openClose.pop();
                else return false;
            }
        }
        while(!open.isEmpty() && !openClose.isEmpty() && openClose.peek() > open.peek()){
            open.pop();
            openClose.pop();
        }
        return open.isEmpty();
    }
}
