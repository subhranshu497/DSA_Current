package com.prep.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfSquareNumber {
    public static void main(String[] args) {
        int n = 10;
        int count = minNoOfSquare(n);
        System.out.println(count);
    }

    private static int minNoOfSquare(int n) {
        return minNoOfSquare(n, new HashMap <Integer, Integer>());
    }

    /**
     * find the minimum number of squares which sum upto result the provided number
     * 10 = 9+1
     * @param n
     * @return
     */
    private static int minNoOfSquare(int n, Map<Integer, Integer> memo) {
        //base case
        if(n==0) return 0;
        if(memo.containsKey(n)) return memo.get(n);
        int minCount = Integer.MAX_VALUE;
        for(int i=1;i<=Math.sqrt(n);i++){
            int sq = i*i;
            int sqCount = 1+minNoOfSquare(n-sq);
            if(sqCount <minCount){
                minCount = sqCount;
            }
        }
        int result= minCount;
        memo.put(n,result);
        return result;
    }

}
