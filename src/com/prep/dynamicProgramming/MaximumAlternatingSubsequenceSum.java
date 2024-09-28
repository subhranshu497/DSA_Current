package com.prep.dynamicProgramming;

import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum {
    public static void main(String[] args) {
        int [] nums = {6,2,1,2,4,5};
        long ans = maxAltSumDP(nums);
        System.out.println(ans);
    }

    private static long maxAltSum(int[] nums) {
        long [][] memo = new long[nums.length+1][2];
        return solveMaxAltSum(0,true, nums, memo);
    }

    private static long solveMaxAltSum(int i, boolean flag, int [] nums, long [][] memo) {
        //base condition
        if(i>=nums.length) return 0;
        if(memo[i][flag?1:0] !=-1) return memo[i][flag?1:0];
        long skip = solveMaxAltSum(i+1, flag, nums, memo);
        int val = nums[i];
        if(!flag) val = -val;
        long take = solveMaxAltSum(i+1, !flag, nums, memo)+val;

        return memo[i][flag?1:0]=Math.max(skip, take);
    }
    //we took 2d array because , we have two variable to change. one is i and the second one is even or odd
    private static long maxAltSumDP(int [] nums){
        long [][] dp = new long[nums.length+1][2];
        //here we have two cases take or skip
        //arr = {a1,a2,a3}, if we take a4 , then substract a4 . OBS - if the array length is odd , then new element will be on odd index , so minus it
        //arr = {a1,a2}, if we take a4 , then add it. OBS - if the arr length is even, then new element will be on even idx, so add it
        for(int i=1;i<= nums.length;i++){
            // in case of even
            dp[i][0] = Math.max(dp[i-1][1]+nums[i-1], dp[i-1][0]);
            //in case of odd
            dp[i][1] = Math.max(dp[i-1][0]-nums[i-1], dp[i-1][1]);
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
