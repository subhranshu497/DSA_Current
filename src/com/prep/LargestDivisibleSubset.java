package com.prep;

import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int [] nums = {2,4,8,16};
        List<Integer> result = largestDivisibleSubset(nums);
        System.out.println(result);
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(nums); //1, 2 , 5, 8
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        } //1,2,2,3
        int max =-1;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        int prev = -1;
        List<Integer> result = new ArrayList<>();
        for(int i =n-1;i>=0;i--){
            if(dp[i]==max && (prev % nums[i]==0 || prev ==-1)){
                result.add(nums[i]);
                max -=1;
                prev = nums[i];
            }
        }
        return result;
    }
}
