package com.prep;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int k = 3;
        int [] nums ={1,5,4,2,9,9,9};
        long sum = maximumSubarraySum(nums, k);
        System.out.println(sum);
    }

    private static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        int i=0, j=0;
        while (j <n){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -=nums[i];
                i++;
            }
                set.add(nums[j]);
                sum +=nums[j];

            if((j-i+1)==k){
                ans = Math.max(sum, ans);
                set.remove(nums[i]);
                sum -=nums[i];
                i++;
            }
            j++;
        }
        return ans==Integer.MIN_VALUE?0:ans;
    }
}
