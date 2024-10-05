package com.prep.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubSet {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<Integer> list = largestDivSubsetDP(nums);
        System.out.println(list);
    }

    //Approach -2
    //it is a variant of LIS
    // so code will be exactly same as LIS
    //only change at the end, need to keep track of indexes which is making LIS
    private static List<Integer> largestDivSubsetDP(int[] nums) {
        int n= nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        //in this array, we will keep track of the indexes which is forming the largest divisible subsequence
        int [] indexTracker= new int[n];
        Arrays.fill(indexTracker, -1);
        int maxLIS = 1;
        int lastIndex = 0;

        for(int i=1;i<n;i++){
            for (int j = 0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i] <dp[j]+1){
                        dp[i] = dp[j]+1;
                        indexTracker[i]=j;
                    }
                    if(dp[i]>maxLIS){
                        maxLIS = dp[i];
                        lastIndex = i;
                    }
                }
            }
        }
        //iterate the indexTracker array to get the sequence
        List<Integer> result = new ArrayList<>();
        while(lastIndex >=0){
            result.addFirst(nums[lastIndex]);
            lastIndex = indexTracker[lastIndex];
        }
        return result;
    }

    //approach -1 - Recursion
    private static List<Integer> largestDivSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        largestDivSubsetRecursion(nums, result, temp, 0,-1);
        return result;
    }

    private static void largestDivSubsetRecursion(int[] nums, List<Integer> result,List<Integer> temp, int index, int prevElement) {
        //base condition
        if(index>= nums.length) {
            if(temp.size() > result.size()){
                result = temp;
            }
            return;
        }
        // take
        int take =0;
        if(prevElement == -1 || nums[index]%prevElement==0){
            temp.add(nums[index]); //take
            largestDivSubsetRecursion(nums, result, temp, index+1, nums[index]);
            temp.removeFirst();
        }
        largestDivSubsetRecursion(nums, result, temp, index+1, prevElement);
    }
}
