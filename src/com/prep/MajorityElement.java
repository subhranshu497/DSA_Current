package com.prep;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode #169
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorEle(nums));
    }

    private static int majorEle(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) map.put(num, map.getOrDefault(num, 0)+1);
        for(int i=0;i<n;i++){
            if(map.get(nums[i])>n/2) ans= nums[i];
        }
        return ans;
    }
}
