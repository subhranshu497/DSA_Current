package com.prep;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(jump(nums));
    }

    private static boolean jump(int[] nums) {
        int i =0;
        int max =0;
        while(i<nums.length){
            if(i>max) return false;
            max = Math.max(max, i+nums[i]);
            i++;
        }
        return true;
    }
}
