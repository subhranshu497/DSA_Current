package com.prep;

import java.util.Arrays;

public class CountPairsInTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,10,6,2};
        int[] nums2 = {1,4,1,5};
        System.out.println(countPairs(nums1, nums2));
    }

    private static long countPairs(int[] nums1, int[] nums2) {
        long count =0l;
        int n = nums2.length;
        int[] diff = new int[n];
        for(int i=0;i<n;i++){
            diff[i] = nums1[i]-nums2[i];
        }
        Arrays.sort(diff);
        int left =0;
        int right =n-1;
        while(left < right){
            if(diff[left]+diff[right]>0){
                count +=right-left;
                right--;
            }
            else left++;
        }
        return count;
    }
}
