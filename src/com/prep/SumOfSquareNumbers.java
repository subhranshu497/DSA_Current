package com.prep;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int c = 5;
        boolean result = judgeSquareSum(c);
    }

    private static boolean judgeSquareSum(int c) {
        for(int a =0;a*a<=c;a++){
            for(int b=0;b*b<=c;b++){
                if((a*a)+(b*b)==c) return true;
            }
        }
        return false;
    }
}
