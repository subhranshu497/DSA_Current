package com.prep;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[]nums = {-1,1,0,-3,3};
        int [] result = prodArr(nums);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] prodArr(int[] nums) {
        int [] result = new int[nums.length];
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        left[0] =1;
        right[nums.length-1] =1;
        for(int i =1;i< nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        for(int i = nums.length-2;i>-1;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        for(int i =1;i< nums.length;i++){
            result[i] = left[i]*right[i];
        }
        return result;
    }
}
