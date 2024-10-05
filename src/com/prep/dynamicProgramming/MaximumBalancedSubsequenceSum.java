package com.prep.dynamicProgramming;

import java.util.Arrays;

public class MaximumBalancedSubsequenceSum {

    // since it is a question of subsequence sum , so LIS can be applied
    //Approach 1 -  LIS using recursion - TLe
    // Approach 2 - Recursion +memo - TLE
    // Approach -3 - DP - TLE
    // Approach -4 - Optimal Approach
    public static void main(String[] args) {
        int [] nums = {3,3,5,6};
       // long result =maxBalancedSubsequenceSum(nums);
        long result = maxBalSubSeqDP(nums);
        System.out.println(result);
    }

    private static long maxBalSubSeqDP(int[] nums) {
        long [] dp = new long[nums.length+1];
        for(int i=0;i< nums.length;i++){
            dp[i] = nums[i];
        }
        long maxSum = Long.MIN_VALUE;
        // if all the element of the array are negative
        long max = Long.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max, num);
        }
        if(max <=0) return max;
        int i=0;
        while (i< nums.length){
            for(int j=0;j<i;j++){
                if (nums[i]-i >= nums[j]-j){
                    dp[i] = Math.max(dp[i], dp[j]+nums[i]);
                    maxSum = Math.max(dp[i], maxSum);
                }
            }
            i++;
        }
        return maxSum>max?maxSum:max;
    }

    private static long maxBalancedSubsequenceSum(int[] nums) {
        //return maxBalSubSeqRecursion(-1, 0, nums);
        long max = Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        if(max <=0) return max;
        long [][] memo = new long[nums.length+1][nums.length+1];
        for(long [] arr :memo){
            Arrays.fill(arr, -1);
        }
        return maxBalSubSeqMemo(-1,0, nums, memo);
    }

    // approach - 2 - using memo  - it also throws TLE
    private static long maxBalSubSeqMemo(int prev, int curr, int[] nums, long[][] memo) {
        //base condition
        if(curr>=nums.length) return 0;
        if(prev !=-1 && memo[prev][curr] !=-1) return memo[prev][curr];
        long take = Long.MIN_VALUE;
        if(prev == -1 || (nums[curr]-curr >= nums[prev]-prev)){
            take = nums[curr]+maxBalSubSeqMemo(curr, curr+1, nums, memo);
        }
        long skip = maxBalSubSeqMemo(prev, curr+1, nums, memo);
        if(prev != -1)memo[prev][curr] = Math.max(take, skip);
        return Math.max(take, skip);
    }



    private static long maxBalSubSeqRecursion(int prev, int curr, int[] nums) {

        //base condition
        if(curr >= nums.length)return 0;
        long take =Long.MIN_VALUE;
        if(prev ==-1 || (nums[curr]-curr >= nums[prev]-prev))
            take = nums[curr]+maxBalSubSeqRecursion(curr, curr+1, nums);
        long skip = maxBalSubSeqRecursion(prev, curr+1,nums);

        return Math.max(take, skip);
    }
}
