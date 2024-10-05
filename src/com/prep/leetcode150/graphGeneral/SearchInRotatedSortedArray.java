package com.prep.leetcode150.graphGeneral;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {1,3};
        int target = 0;
        int result = search1(nums, target);
        System.out.println(result);
    }

    private static int findPivot(int[] nums, int n) {
        int left =0;
        int right = n-1;
        int pivotIndex = -1;
        while(left <right){
            int mid = left+(right-left)/2;
            if(nums[mid] >nums[right]){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
    private static int search1(int[] nums, int target) {
        //Step -1 : find the pivot index
        // pivot index - since it is a sorted array so num < num of right
        // if any point we find the above relation is not fllowed , then that is the pivot index
        int n = nums.length;
        if(n==1){
            if(nums[0] == target) return 0;
            else return -1;
        }
        int pivotIndex = findPivot(nums, n);
        // step -2 : call the binary search twice , first from left to mid
        // from mid+1 to right
        int fromLeftSubArr = binarySearchPivotIndex(nums, n, 0, pivotIndex-1, target);
        int fromRightSubArr = binarySearchPivotIndex(nums, n, pivotIndex, n-1, target);
        return Math.max(fromLeftSubArr, fromRightSubArr);
    }

    private static int binarySearchPivotIndex(int[] nums, int n, int l, int r, int target) {
        while (l <=r){
            int mid = l+(r-l)/2;
            if(nums[mid]<target)l = mid+1;
            else if(nums[mid] > target) r = mid-1;
            else return mid;
        }
        return -1;
    }
}
