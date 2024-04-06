package com.prep.hackerRank.RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        int n =3;
        result = genParenthesis(n);
        System.out.println(result);
    }

    private static List<String> genParenthesis(int n) {
        String curr = "(";
        genParenRecursion(n, 1,0, curr);
        return result;
    }
    private static void genParenRecursion(int n, int open, int close,String current){
        //base condition
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        if(close <open) {
            genParenRecursion(n, open, close + 1, current + ")");
        }
        if(open <n){
            genParenRecursion(n,open+1,close,current+"(");
        }
    }
}
