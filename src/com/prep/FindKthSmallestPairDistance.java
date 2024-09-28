package com.prep;

import java.text.BreakIterator;
import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k=3;
        int small = smallestDistancePair(nums, k);
        System.out.println(small);
    }

    private static int smallestDistancePair(int[] nums, int k) {
        //minimum distance between two distance is 0, if both elements are same
        //max distance = after sorting diff between max-min
        Arrays.sort(nums);
        int low =0;
        int high =nums[nums.length-1]-nums[0];
        while(low<high){
            int mid = (low+high)/2;
            if(isSmallestPairs(nums,k,mid)) high =mid;
            else low = mid+1;
        }
        return low;
    }

    private static boolean isSmallestPairs(int[] nums, int k, int mid) {
        int count=0;
        int left=0;
        for(int right=1;right< nums.length;right++){
            while((nums[right]-nums[left])>mid){
                left++;
            }
            count +=right-left;
        }
        return (count>=k);
    }
}
