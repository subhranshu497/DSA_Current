package com.prep.workday;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int target = 6;
        int [] result = twoSum(nums,target);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int inv = target-nums[i];
            if(map.containsKey(inv) && i !=map.get(inv)){
                result[0]=i;
                result[1]=map.get(inv);
            }
        }
        return result;
    }
}
