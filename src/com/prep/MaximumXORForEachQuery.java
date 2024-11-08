package com.prep;

public class MaximumXORForEachQuery {
    public static void main(String[] args) {
        int [] nums = {0,1,1,3};
        int maxBits = 2;
        int [] result = getMaximumXor(nums,maxBits);
    }

    private static int[] getMaximumXor(int[] nums, int maxBits) {
        int xor = 0;
        int [] result = new int[nums.length];
        for(int num :nums){
            xor ^=num;
        }
        int mask = (1<< maxBits)-1;
        for(int i=0;i< nums.length;i++){
            int k = xor ^ mask;
            result[i] = k;
            xor ^=nums[nums.length-1-i];
        }
        return result;
    }
}
