package com.prep;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums ={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
    private static int longestOnes(int[] nums, int k) {
        int right = 0;
        int left =0;
        for(;right<nums.length;right++){
            if(nums[right]==0) k--;
            if(k<0){
                k +=1-nums[left];
                left++;
            }
        }
        return right -left;
    }
}
