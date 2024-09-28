package com.prep.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class NonAdjacentMaxSum {
    public static void main(String[] args) {
        int [] nums = {2,5,1,7,3};
        int result = nonAdjMaxSum(nums);
        System.out.println(result);
    }

    private static int nonAdjMaxSum(int[] nums) {
        return nonAdjMaxSumHelper(0,nums, new HashMap<Integer, Integer>());
    }

    private static int nonAdjMaxSumHelper(int i, int[] nums, Map<Integer, Integer> memo) {
        //base condition
        if(i>= nums.length)return 0;
        if(memo.containsKey(i)) return memo.get(i);
        int result =Math.max(nums[i]+nonAdjMaxSumHelper(i+2, nums, memo),nonAdjMaxSumHelper(i+1, nums, memo));
        memo.put(i,result);
        return result;
    }
}
