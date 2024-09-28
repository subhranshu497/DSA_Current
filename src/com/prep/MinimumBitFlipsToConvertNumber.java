package com.prep;

public class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        int start = 3;
        int goal =4;
        int count = minBitFlip(start, goal);
        System.out.println(count);
    }

    private static int minBitFlip(int start, int goal) {
        int count =0;
        int xor = start ^ goal;
        while(xor !=0){
            count +=xor & 1;
            xor >>=1;
        }
        return count;
    }
}
