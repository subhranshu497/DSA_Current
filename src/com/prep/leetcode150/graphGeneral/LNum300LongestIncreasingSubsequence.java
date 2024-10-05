package com.prep.leetcode150.graphGeneral;

import java.util.Arrays;

public class LNum300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        int lis = lis(nums);
        System.out.println(lis);
    }

    private static int lis(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j< i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int lis = 0;
        for(int num:dp)lis = Math.max(lis, num);
        return lis;
    }
}
