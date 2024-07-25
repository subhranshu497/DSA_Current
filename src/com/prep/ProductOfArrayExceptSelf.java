package com.prep;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[]nums = {1,2,3,4};
        int [] result = prodArr(nums);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] prodArr(int[] nums) {
        int[] result = new int[nums.length];
        int[] lresult = new int[nums.length];
        int[] rresult = new int[nums.length];
        lresult[0]=1;
        rresult[nums.length-1]=1;
        //product from left to right
        for(int i=1;i<nums.length;i++){
            lresult[i] =lresult[i-1] * nums[i-1];
        }
        //prod from right to left
        for(int i=nums.length-2;i>=0;i--){
            rresult[i] =rresult[i+1] * nums[i+1];
        }
        //find result
        for(int i=0;i<nums.length;i++){
            result[i]=lresult[i]*rresult[i];
        }
        return result;
    }
}
