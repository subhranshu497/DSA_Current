package com.prep;

public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int [] results = sortArray(nums);

        for(int num:results) System.out.print(num+" ,");
    }

    private static int[] sortArray(int[] nums) {
        int n = nums.length;
        //find max and min
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            max = Math.max(num,max);
            min = Math.min(num, min);
        }
        //calculate range
        int range = max-min+1;
        int [] count = new int[range];
        //traverse nums and fill one in num-min pos of count
        for(int i=0;i<n;i++){
            count[nums[i]-min]++;
        }
        //iterate count array and form result array in the same space as nums
        int index=0;
        for(int i=0;i<range;i++){
            while(count[i]-- >0){
                nums[index]=i+min;
                index++;
            }
        }
        return nums;
    }

}
