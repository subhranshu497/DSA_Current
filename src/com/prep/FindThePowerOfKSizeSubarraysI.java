package com.prep;

import java.util.Arrays;

public class FindThePowerOfKSizeSubarraysI {
    public static void main(String[] args) {
        int [] nums = {3,2,3,2,3,2};
        int k = 2;
        int [] res = resultsArray(nums, k);
        for(int num:res)
            System.out.print(num+", ");
    }

    private static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int m = n-k+1;
        int [] result = new int[m];
        Arrays.fill(result, -1);
        int count =1;
        for(int i=1;i<k;i++){
            if(nums[i] == nums[i-1]+1)
                count++;
            else count =1;
        }
        if(count == k)
            result[0] = nums[k-1];
        int j = k;
        int i =1;
        while(j < n){
            if(nums[j] == nums[j-1]+1)
                count++;
            else count =1;

            if(count >=k)
                result[i] = nums[j];
            j++;
            i++;
        }
        return result;
    }
}
