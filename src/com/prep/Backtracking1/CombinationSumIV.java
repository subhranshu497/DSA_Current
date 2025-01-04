package com.prep.Backtracking1;

import java.util.Arrays;

public class CombinationSumIV {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int target = 4;
        int count = combinationSum4(nums, target);
        System.out.println(count);
    }

    private static int combinationSum4(int[] nums, int target) {
        int [][] memo = new int[201][1001];
        for(int [] arr : memo) Arrays.fill(arr, -1);
        int count =solveComSumIV(nums,target, 0, memo);
        return count;
    }

    private static int solveComSumIV(int[] nums, int target, int idx, int [][] memo) {
        //base condition
        if(target==0)return 1;
        if(idx >= nums.length || target < 0) return 0;
        if(memo[idx][target] != -1) return memo[idx][target];
        int take =solveComSumIV(nums, target-nums[idx],0, memo);
        int skip =solveComSumIV(nums, target,idx+1, memo);

        return memo[idx][target]=take+skip;
    }
}
