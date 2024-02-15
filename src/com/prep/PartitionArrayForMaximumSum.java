package com.prep;

import java.util.Arrays;

/**
 * Leetcode 1043
 */
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    private static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSumAfterPartitioningHelper(0,arr,k,dp);
    }

    private static int maxSumAfterPartitioningHelper(int i, int[] arr, int k, int[] dp) {
        int n = arr.length;
        if(i==n) return 0;
        if(dp[i] != -1) return dp[i];
        int len =0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int j=i;j<Math.min(i+k, n);j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum = len*max + maxSumAfterPartitioningHelper(j+1, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[i] = maxAns;
    }
}
