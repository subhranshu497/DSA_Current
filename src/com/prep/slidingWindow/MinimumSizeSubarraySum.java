package com.prep.slidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(nums, target);
        System.out.println(result);
    }

    private static int minSubArrayLen(int[] nums, int target) {
        int minLen = nums.length;
        int i= 0;
        int j =0;
        int sum = 0;
        boolean flag = false;
        while(j<nums.length){
            sum += nums[j];
            while(sum >= target){
                minLen = Math.min(minLen, j-i+1);
                flag = true;
                sum -=nums[i];
                i++;
            }
            j++;
        }

        return flag==true?minLen:0;
    }
}
