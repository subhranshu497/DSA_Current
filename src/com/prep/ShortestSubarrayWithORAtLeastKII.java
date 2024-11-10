package com.prep;

public class ShortestSubarrayWithORAtLeastKII {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int k =2;
        int len = minimumSubarrayLength(nums, k);
        System.out.println(len);
    }

    private static int minimumSubarrayLength(int[] nums, int k) {
        int num =0;
        int i =0;
        int j =0;
        int n = nums.length;
        int ans =Integer.MAX_VALUE;
        int [] bitPos = new int[32]; // total no of set bits in ith position
        while (j<n){
            updateWindow(nums[j], bitPos, 1);
            while(getDecimalNumber(bitPos) >= k && i<=j){
                ans = Math.min(ans, j-i+1);
                updateWindow(nums[i], bitPos, -1);
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }

    private static int getDecimalNumber(int[] bitPos) {
        int num =0;
        for(int i=0;i<32;i++){
            if(bitPos[i]>0){
                num |=(1<<i);
            }
        }
        return num;
    }

    private static void updateWindow(int num, int[] bitPos, int value) {
        for(int i=0;i<32;i++){
            if(((num>>i)&1) == 1)
                bitPos[i] +=value;
        }
    }
}
