package com.prep;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k=6;
        boolean flag = checkSubarraySum(nums,k);
    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefixMod =0;
        for(int i=0;i< nums.length;i++){
            prefixMod =(prefixMod+nums[i])%k;
            if(map.containsKey(prefixMod)){
                if(i-map.get(prefixMod)>1) return true;
            }
            else {
                map.put(prefixMod,i);
            }
        }
        return false;
    }
}
//0- -1
//5-0
//1-1
//
