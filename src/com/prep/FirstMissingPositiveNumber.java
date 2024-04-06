package com.prep;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(findPositive(nums));
    }

    private static int findPositive(int[] nums) {
        boolean flag = false;
        for(int i=0;i< nums.length;i++){
            if(nums[i]==1){
                flag = true;
                break;
            }
        }
        if(!flag) return 1;
        int length = nums.length;
        if(length==1) return 2;
        for(int i=0;i<length;i++){
            if(nums[i] <=0 || nums[i] >length) nums[i] =1;
        }
        for(int i=0;i<length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1]>0) nums[num-1] *=-1;
        }
        for(int i=0;i<length;i++){
            if(nums[i]>0)return i+1;
        }
        return length+1;
    }
}
