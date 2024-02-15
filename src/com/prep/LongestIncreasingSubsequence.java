package com.prep;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(LIS(nums));
    }

    private static int LIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=1;i< nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i] =dp[j]+1;
                    }
                }
            }
        }
        int max =0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>dp[max]) max = i;
        }
        return dp[max]+1;
    }
}
