package com.prep;

import java.util.HashMap;
import java.util.Map;

public class RearrangeArrayElementsbySign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int [] result = rearrangeArray(nums);
        for(int i=0;i< nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    private static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for(int i=0;i< nums.length;i++){
            if(nums[i]<0){
                result[negativeIndex]=nums[i];
                negativeIndex +=2;
            }
            else{
                result[positiveIndex]=nums[i];
                positiveIndex +=2;
            }
        }
        return result;
    }
}
