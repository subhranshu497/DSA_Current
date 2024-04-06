package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = {1,2,3,1,2,3,1,2};
        System.out.println(maxSubarrayLength(nums,k));
    }

    /**
     * 1 -2
     * 2 -3
     * 3 -2
     *
     */

    private static int maxSubarrayLength(int[] nums, int k) {
        int result =0;
        int n= nums.length;
        int left = 0;
        int right =0;
        Map<Integer, Integer> map = new HashMap<>();
        while(left <n && right < n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.get(nums[right])>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}
