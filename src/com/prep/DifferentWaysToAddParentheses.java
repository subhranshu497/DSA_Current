package com.prep;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> result = diffWaysToCompute(expression);
        System.out.println(result);
    }

    private static List<Integer> diffWaysToCompute(String expression) {
        return diffWaysToComputeHelper(expression);
    }
    private static List<Integer> diffWaysToComputeHelper(String expression) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='*'||expression.charAt(i)=='-'){
                List<Integer> leftSubArr = diffWaysToComputeHelper(expression.substring(0,i));
                List<Integer> rightSubArr = diffWaysToComputeHelper(expression.substring(i+1,expression.length()));
                for(int l:leftSubArr){
                    for(int r:rightSubArr){
                        if(expression.charAt(i)=='+')result.add(l+r);
                        if(expression.charAt(i)=='*')result.add(l*r);
                        else result.add(l-r);
                    }
                }
            }
        }
       if(result.size()==0) result.add(Integer.parseInt(expression));
       return result;
    }
}
