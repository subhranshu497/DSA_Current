package com.prep.dynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int money = rubbedHouseDP(nums);
        System.out.println(money);
    }

    //approach -1 - Recursion
    private static int rubbedMoneyRecursion(int[] nums) {
        int [] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return rubbedMoneyRecSolve(nums,0, memo);
    }

    private static int rubbedMoneyRecSolve(int[] nums, int i, int [] memo) {
        if(i>= nums.length) return 0;
        if(memo[i] != -1) return memo[i];
        int steal = nums[i]+ rubbedMoneyRecSolve(nums, i+2, memo);
        int skip = rubbedMoneyRecSolve(nums, i+1, memo);
        return memo[i] = Math.max(skip, steal);
    }

    //approach 2 - bottom up - DP
    // dp[i] - max stolen money till house i
    private static int rubbedHouseDP(int [] nums){
        int n = nums.length;
        int [] dp = new int[n+1];
        // when the nums length is zero , i.e = no houses to rub
        dp[0] =0;
        //when there is only one house to rub
        dp[1] = nums[0];
        for(int i=2;i<n;i++){
            int steal = nums[i-1]+dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(steal, skip);
        }
        return dp[n-1];
    }

}
