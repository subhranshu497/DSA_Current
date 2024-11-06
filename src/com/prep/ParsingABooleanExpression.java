package com.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {
    public static void main(String[] args) {
        String s = "(&(f,t))";
        boolean flag = parseBoolExpr(s);
        System.out.println(flag);
    }

    private static boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch==',')continue;
            if(ch==')'){
                List<Character> charList = new ArrayList<>();
                while(!st.empty() && (st.peek() != '(')){
                    charList.add(st.pop());
                }
                //pop the opening brace
                st.pop();
                char ops = st.pop();
                char result = evaluateExpression(ops, charList);
                st.push(result);
            }else{
                st.push(ch);
            }
        }
        return st.peek()=='t';
    }

    private static char evaluateExpression(char ops, List<Character> charList) {
        if(ops == '!') return charList.get(0)=='t'?'f':'t';
        else if(ops == '&'){
            for(char c:charList){
                if(c=='f') return 'f';
            }
            return 't';
        }else {
            for(char c:charList){
                if(c=='t') return 't';
            }
            return 'f';
        }
    }
}
