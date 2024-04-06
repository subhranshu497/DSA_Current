package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayOf1AfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    private static int longestSubarray(int[] nums) {
        int maxLen =0;
        int prev =0;
        int curr=0;
        for(int num:nums){
            if(num ==1)curr++;
            else{
                maxLen = Math.max(maxLen, curr+prev);
                prev = curr;
                curr=0;
            }
        }
        maxLen = Math.max(maxLen, curr+prev);
       return maxLen==nums.length?maxLen-1:maxLen;
    }
}
