package com.prep;

public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        int [] candidates = {16,17,71,62,12,24,14};
        int largest = largestCombination(candidates);
        System.out.println(largest);
    }

    private static int largestCombination(int[] candidates) {
        //represent in binary
        //find the number of set bits for each candidates
        //return the max set bit
        //32 is the range , as max 32 bit can be possible
        int result =Integer.MIN_VALUE;
        for(int b=0;b<32;b++){
            int tempMax = 0;
            for(int c:candidates){
                //to find the set bit
                if((c & (1<<b)) != 0)
                    tempMax++;
            }
            result = Math.max(result, tempMax);
        }
        return result;
    }
}
