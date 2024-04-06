package com.prep;

import java.util.HashMap;
import java.util.Map;

public class ContinguousArray {
    public static void main(String[] args) {
        int [] nums = {1,1,0,0,1,1,0,1,1};
        System.out.println(longestArray(nums));
    }

    private static int longestArray(int[] nums) {
        int longestLength=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i< nums.length;i++){
            sum += nums[i]==1?1:-1;

            if(!map.containsKey(sum))map.put(sum,i);
            else{
                longestLength = Math.max(longestLength, i-map.get(sum));
            }
        }
        return longestLength;
    }
}
