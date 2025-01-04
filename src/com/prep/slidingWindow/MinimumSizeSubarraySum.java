package com.prep.slidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        int result = minSubArrayLen(nums, target);
        System.out.println(result);
    }

    private static int minSubArrayLen(int[] nums, int target) {
       int n = nums.length;
       int i =0;
       int j =0;
       int ans = Integer.MAX_VALUE;
       int tempSum = 0;
       while(j < n){
           tempSum += nums[j];
           while(tempSum >= target){
               tempSum -=nums[i];
               ans = Math.min(ans, j-i+1);
               i++;
           }
           j++;
       }
       return ans==Integer.MAX_VALUE ? 0:ans;
    }
}
