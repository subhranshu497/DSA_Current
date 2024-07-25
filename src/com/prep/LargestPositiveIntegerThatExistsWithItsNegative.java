package com.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] nums = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(nums));
    }

    private static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int right = nums.length-1;
        int left=0;
        while(left<right){
            int abs = Math.abs(nums[left]);
            if(abs==nums[right]) return nums[right];
            else if(abs < nums[right])right--;
            else left++;
        }
        return -1;
    }
}
