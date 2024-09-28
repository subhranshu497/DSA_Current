package com.prep.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = searchRotateArray(nums, target);
        System.out.println(index);
    }

    private static int searchRotateArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        return searchRotatedArrayHelper(nums, target, low, high);
    }

    private static int searchRotatedArrayHelper(int[] nums, int target, int low, int high) {
        int mid = (low+high)/2;
        if(nums[mid]==target) return mid;
        //if the part of array is sorted
        if(nums[mid]>nums[low]){
            if(target <=nums[mid] && target >=nums[low]){
                return searchRotatedArrayHelper(nums,target,low,mid-1);
            }
            else{
                return searchRotatedArrayHelper(nums,target,mid+1,high);
            }
        }
        else {
            if(target <=nums[high] && target >=nums[mid]){
                return searchRotatedArrayHelper(nums,target,low,mid+1);
            }
            else{
                return searchRotatedArrayHelper(nums,target,mid-1,high);
            }
        }
    }
}
