package com.prep.binarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2};
        int ans = findMin1(nums);
        System.out.println(ans);
    }

    private static int findMin1(int[] nums) {
        int n = nums.length;
        int left =0;
        int right = n-1;
        while(left<right){
            int mid = left+(right-left)/2;
            //in a sorted array this condition should ot be possible
            // since it is a rotated array, so ans ans lies in this part, if the condition is true
            //since already nums[mid] > nums[right], so nums[mid] cant be a minimum element
            if (nums[mid]>nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return nums[right];
    }
}
