package com.prep;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int [] nums = {0,1,7,4,4,5};
        int lower = 3;
        int upper =6;
        long pairCount = countFairPairs(nums, lower, upper);
        System.out.println(pairCount);
    }

    //it is yet to be corrected
    private static long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0l;
        int n = nums.length;
        Arrays.sort(nums);
        int low=0;
        int high=1;
        int ptr =0;
        while(low < high){
            int mid = low + (high-low)/2;
            while(mid == lower && low !=ptr){
                ptr = lower;
                if(nums[low]+nums[ptr]<=upper && nums[low]+nums[ptr] >=lower){
                    count++;
                    low++;
                    continue;
                }
            }
        }
        return count;
    }
}
