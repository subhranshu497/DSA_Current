package com.prep;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {
    public static void main(String[] args) {
        int [] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }

    private static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            if(sum==goal){
                count ++;
            }
            if(map.containsKey(sum-goal)){
                count +=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
