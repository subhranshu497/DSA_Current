package com.prep;

import java.util.Arrays;

public class MinimDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        int [] nums = {3,100,20};
        int result = minDifference(nums);
        System.out.println(result);
    }

    private static int minDifference(int[] nums) {
        int result =0;
        int n = nums.length;
        Arrays.sort(nums);
        if(n<=4) return 0;
        int option1 = nums[n-4]- nums[0];
        int option2 = nums[n-3]- nums[1];
        int option3 = nums[n-2]- nums[2];
        int option4 = nums[n-1]- nums[3];
        result = Math.min(option1, option2);
        result = Math.min(result,option3);
        result = Math.min(result,option4);
        return result;
    }
}
