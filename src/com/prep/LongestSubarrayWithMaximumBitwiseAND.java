package com.prep;

public class LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int [] nums = {1,2,3,3,2,2};
        int len = longestSubarrayBitwiseAnd(nums);
        System.out.println(len);
    }

    private static int longestSubarrayBitwiseAnd(int[] nums) {
        int maxLen = 0;
        int maxTemp = Integer.MIN_VALUE;
        int result=0;
        for(int num:nums){
            if(num >maxTemp){
                maxTemp = num;
                maxLen = 0;
                result=0;
            }
            if(num==maxTemp){
                maxLen +=1;
            }
        }
        result = Math.max(result, maxLen);
        return result;
    }
}
