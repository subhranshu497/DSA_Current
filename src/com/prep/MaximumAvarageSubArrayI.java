package com.prep;

public class MaximumAvarageSubArrayI {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k =4;
        System.out.println(findMaxAverage(nums,k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        double sum =0;
        for(int i=0;i<k;i++)
        {
            sum +=nums[i];
        }
        double result = sum;
        for(int i=k;i<nums.length;i++){
            sum +=nums[i]-nums[i-k];
            result = Math.max(result,sum);
        }
        return result/k;
    }
}
