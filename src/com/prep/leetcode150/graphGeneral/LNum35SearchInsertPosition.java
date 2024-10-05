package com.prep.leetcode150.graphGeneral;

public class LNum35SearchInsertPosition {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 5;
        int pos = searchInsert(nums, target);
        System.out.println(pos);
    }

    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right =n-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            else if(target < nums[mid])right =mid-1;
            else left = mid+1;
        }
        return left;
    }
}
