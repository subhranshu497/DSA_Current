package com.prep;

import java.util.Arrays;

public class MaximumBeautyArrayAfterApplyingOperation {
    public static void main(String[] args) {
        int [] nums = {4,6,1,2};
        int k = 2;
        int beauty = maximumBeautyI(nums, k);
        System.out.println(beauty);
    }

    private static int maximumBeautyI(int[] nums, int k) {
        int left =0;
        int right =0;
        int result = Integer.MIN_VALUE;
        int count = 0;
        Arrays.sort(nums);

        while(right < nums.length){
            while(right < nums.length && nums[right]-nums[left] <= 2*k){
                count++;
                right++;
            }
            result = Math.max(count, result);
            if(right== nums.length) break;
            while(left <= right && nums[right]-nums[left] >=2*k){
                count--;
                left++;
            }
        }
        return result;
    }
}
