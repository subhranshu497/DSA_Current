package com.prep.hackerRank;

public class MaxArraySum {
    public static void main(String[] args) {
        int [] arr = {-2,1,3,-4,5};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
        int [] dp = new int[arr.length];
        dp[0]=Math.max(arr[0],0);
        dp[1]=Math.max(arr[1],dp[0]);
        for(int i=2;i<arr.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[arr.length-1];
    }
}
