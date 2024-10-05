package com.prep.leetcode150.graphGeneral;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int [] nums = {1};
        int target = 1;
        int [] result = searchRange(nums, target);
        System.out.println(result[0]+" "+result[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        int leftBound = searchForLeftRange(nums, target, n);
        int rightBound = searchForRightRange(nums, target, n);
        return new int[]{leftBound, rightBound};
    }
//5,7,7,8,8,10
    private static int searchForLeftRange(int[] nums, int target, int n) {
        int left = 0;
        int right = n-1;
        int leftBound =-1;
        while(left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                leftBound = mid;
                right = mid-1;
            }
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return leftBound;
    }
    private static int searchForRightRange(int[] nums, int target, int n) {
        int left = 0;
        int right = n-1;
        int rightBound =-1;
        while(left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                rightBound = mid;
                left = mid+1;
            }
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return rightBound;
    }
}
