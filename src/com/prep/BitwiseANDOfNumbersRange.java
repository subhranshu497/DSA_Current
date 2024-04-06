package com.prep;

public class BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    private static int rangeBitwiseAnd(int left, int right) {
        int shiftCount =0;
        while(left !=right){
            left>>=1;
            right>>=1;
            shiftCount++;
        }
        return left<<shiftCount;
    }
}
