package com.prep;

import java.util.Arrays;

public class CuttingRibbon {
    public static void main(String[] args) {
        int [] nums = {7,5,9};
        int k = 4;
        int ans = cutRibbon(nums, k);
        System.out.println(ans);
    }

    private static int cutRibbon(int[] nums, int k) {
        int high = Arrays.stream(nums).max().getAsInt();
        int low =1;
        while(low <=high){
            int mid = low+(high-low)/2;
            if(noOfRibbons(nums,mid,k)<k)
                high = mid-1;
            else
                low = mid+1;
        }
        return high;
    }

    private static int noOfRibbons(int[] nums, int len, int k) {
        int count =0;
        for(int r:nums){
            count +=r/len;
        }
        return count;
    }
}
