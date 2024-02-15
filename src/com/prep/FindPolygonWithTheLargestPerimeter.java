package com.prep;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {
    public static void main(String[] args) {
        int[]nums ={5,5,5};
        System.out.println(largestPerimeter(nums));
    }

    private static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        int i=nums.length-1;
        while(i>=0){
            if(sum-nums[i]>nums[i])return sum;
            sum -=nums[i];
            i--;
        }
        return -1;
    }
}
