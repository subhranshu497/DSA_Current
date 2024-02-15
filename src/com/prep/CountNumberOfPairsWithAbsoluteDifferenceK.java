package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        int [] nums = {1,2,2,1};
        int k = 1;
        System.out.println(countKDifference(nums, k));
    }

    private static int countKDifference(int[] nums, int k) {
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]+k))count +=map.get(nums[i]+k);
            if(map.containsKey(nums[i]-k))count +=map.get(nums[i]-k);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}
