package com.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> l:result)
            System.out.println(l);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;;
        Arrays.sort(nums);
        //n1+n2+n3=0
        //n2+n3 = -n1
        int j =1;
        int k = nums.length-1;
        for(int i=0;i<n;i++){
            if(i !=0 && nums[i]==nums[i-1]){
                continue;
            }
            int n1 = nums[i];
            int target = -n1;
            twoSum1(nums, target, i+1,n-1, result);
        }
        return result;
    }

    private static void twoSum1(int[] nums, int target, int i, int j, List<List<Integer>> result) {

        while(i<j){
            if(nums[i]+nums[j] >target){
                j--;
            }
            else if (nums[i]+nums[j] <target)i++;
            else{
                while (nums[i]==nums[i+1])i++;
                while (nums[j]==nums[j-1])j--;
                List<Integer> l = new ArrayList<>();
                l.add(-target);
                l.add(nums[i]);
                l.add(nums[j]);
                result.add(new ArrayList<>(l));
                i++;
                j--;
            }
        }
    }
}
