package com.prep;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
        int [] result = sqrOfArr(nums);
        for(int num:result){
            System.out.print(num+", ");
        }
    }

    private static int[] sqrOfArr(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            nums[i] *= nums[i];
        }
        return nums;
    }
}
