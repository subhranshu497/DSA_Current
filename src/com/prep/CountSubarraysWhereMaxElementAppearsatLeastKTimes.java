package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public static void main(String[] args) {
        int [] nums = {1,3,2,3,3};
        int k =2;
        System.out.println(countSubarrays(nums,k));
    }

    private static long countSubarrays(int[] nums, int k) {
        int max=0;
        int count =0;
        for(int num:nums) max = Math.max(max,num);
        long ans=0;
        int left = 0;
        int right =0;
        while(right<nums.length){
            if(nums[right] ==max){
                count++;
            }
            while(count==k){
                if(nums[left] ==max){
                    count--;
                }
                left++;
            }
            ans +=left;
            right++;
        }
        return ans;
    }
}
