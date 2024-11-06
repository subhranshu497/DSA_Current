package com.prep;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfMaximumBitwiseORSubsets {
    private static int count=0;
    public static void main(String[] args) {
        int [] nums = {3,2,1,5};
        count =countMaxOrSubsets(nums);
        System.out.println(count);
    }

    private static int countMaxOrSubsets(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int num:nums)l.add(num);
        //first calculate the max or
        int maxOr = maxOrCalculation(l);
        countSubsetRec(nums,new ArrayList<>(),0,maxOr);
        return count;
    }

    private static void countSubsetRec(int[] nums, List<Integer> ds, int i, int maxOr) {
        //base condition
        if(i==nums.length){
            int currOr = maxOrCalculation(ds);
            if(currOr==maxOr)
                count++;
            return;
        }
        //take
        ds.add(nums[i]);
        countSubsetRec(nums,ds,i+1, maxOr);
        //skip
        ds.remove(ds.size()-1);
        countSubsetRec(nums,ds,i+1,maxOr);
    }
    private static int maxOrCalculation(List<Integer> nums){
        int maxOr=0;
        for(int i=0;i< nums.size();i++){
            maxOr = maxOr | nums.get(i);
        }
        return maxOr;
    }
}
