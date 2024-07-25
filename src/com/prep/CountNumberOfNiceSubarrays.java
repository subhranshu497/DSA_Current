package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,4,6};
        int k =1;
        int nice = numberOfSubarrays(nums, k);
        System.out.println(nice);
    }

    private static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        int sum =0;
        int prefixSum =0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            prefixSum =nums[i]%2;
            sum =sum+prefixSum;

            if(map.containsKey(sum-k)){
                count +=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
