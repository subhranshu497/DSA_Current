package com.prep;

public class BitwiseXOROfAllPairings {
    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        int res = xorAllNums(nums1, nums2);
        System.out.println(res);
    }

    private static int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int num1 =0;
        int num2 =0;
        if(n1 % 2 !=0){
            for(int num:nums2){
                num2 ^=num;
            }
        }
        if(n2 % 2 !=0){
            for(int num:nums1){
                num1 ^=num;
            }
        }
        return num1 ^ num2;
    }
}
