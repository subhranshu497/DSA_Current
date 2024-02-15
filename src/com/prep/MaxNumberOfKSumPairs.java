package com.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations(nums,k));
    }

    private static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count =0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum<k)i++;
            else if(sum>k)j--;
            else{
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
