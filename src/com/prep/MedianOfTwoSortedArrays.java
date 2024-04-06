package com.prep;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(median(nums1,nums2));
    }

    private static double median(int[] nums1, int[] nums2) {
        double result = 0.0;
        int[]merged = new int[nums1.length+nums2.length];
        int l1 = nums1.length;
        for(int i=0;i<merged.length;i++){
            if(i<nums1.length)merged[i]=nums1[i];
            else{
                merged[i]= nums2[i-l1];
            }
        }
        Arrays.sort(merged);
        return merged.length%2!=0?merged[(merged.length/2)]:(double) (merged[merged.length/2]+merged[(merged.length/2)-1])/2;
    }
}
