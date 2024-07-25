package com.prep;

public class BitwiseOrAllSubsequenceSum {
    public static void main(String[] args) {
        int [] nums = {2,1,0,3};
        System.out.println(sumOfAllSub(nums));
    }

    private static long sumOfAllSub(int[] nums) {
        long result =0;
        long prefixSum =0;
        for(int num :nums){
            prefixSum +=num;
            result |=num | prefixSum;
        }
        return result;
    }
}
