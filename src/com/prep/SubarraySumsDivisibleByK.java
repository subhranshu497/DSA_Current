package com.prep;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int [] nums = {4,5,0,-2,-3,1};
        int k=5;
        int count = subarraysDivByK(nums,k);
        System.out.println(count);
    }

    private static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        map.put(0,1);
        int prefixRem=0;
        int prefixSum =0;
        for(int i=0;i<nums.length;i++){
            prefixSum +=nums[i];
            prefixRem = prefixSum%k;
            if(prefixRem <0) prefixRem +=k;
            if(map.containsKey(prefixRem)){
                count +=map.get(prefixRem);
                map.put(prefixRem,map.getOrDefault(prefixRem,0)+1);
            }
            else map.put(prefixRem,1);
        }
        System.out.println(map);
        return count;
    }
}
