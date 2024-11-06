package com.prep;

import java.util.Arrays;

public class MinimumNumberOfRemovalsToMakeMountainArray {

    private static int [] dp1;
    private static int [] dp2;
    public static void main(String[] args) {
        int [] nums = {4,3,2,1,1,2,3,1};
        int removals = minimumMountainRemovals(nums);
        System.out.println(removals);
    }

    private static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int LIS = lis1(nums);
        int LDS = lds(nums);
        int removals = n;
        for (int i=0;i<n;i++){
            if(dp1[i] >1 && dp2[i] >1)
                removals = Math.min(removals, n-dp1[i]-dp2[i]+1);
        }
        return removals;
    }

    private static int lis1(int[] nums) {
        int n = nums.length;
        dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
            }
        }
        // to find lis
        int LIS =Integer.MIN_VALUE;
        for(int num:dp1){
            LIS = Math.max(LIS, num);
        }
        return LIS;
    }

    // to calculate Longest decreasing Subsequence
    private static int lds(int[] nums) {
        int n = nums.length;
        dp2 = new int[n];
        Arrays.fill(dp2, 1);
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[j]<nums[i]){
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }
        // to find lis
        int LDS =Integer.MIN_VALUE;
        for(int num:dp2){
            LDS = Math.max(LDS, num);
        }
        return LDS;
    }
}
