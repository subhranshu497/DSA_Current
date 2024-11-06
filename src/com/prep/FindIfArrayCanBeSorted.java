package com.prep;

public class FindIfArrayCanBeSorted {
    public static void main(String[] args) {
        int [] nums = {3,16,8,4,2};
        System.out.println(canBeSorted(nums));
    }

    private static boolean canBeSorted(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                int count1 = countNoOfSetBits(nums[j]);
                int count2 = countNoOfSetBits(nums[j+1]);
                if(nums[j]<=nums[j+1]){
                    continue;
                }
                else {
                    if(count1 == count2){
                        swap2(nums[j], nums[j+1], nums,j);
                    }
                    else return false;
                }
            }
        }
        //print the array
        for(int num:nums) System.out.print(num+", ");
        return true;
    }

    private static int countNoOfSetBits(int num) {
        int count =0;
        while(num >0){
            num = num & (num-1);
            count++;
        }
        return count;
    }


    private static void swap2(int a, int b, int [] nums, int j) {
        int temp =a;
        nums[j] = b;
        nums[j+1] =temp;
    }

}
