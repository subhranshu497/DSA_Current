package com.prep.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for(List<Integer> l:res) System.out.println(l);
        System.out.println(res.size());
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetRec(nums, res, new ArrayList<>(), 0);
//        for(int i=0;i<nums.length;i++){
//
//        }
        return res;
    }

    private static void subsetRec(int[] nums, List<List<Integer>> res, List<Integer> temp, int idx) {
        //base condition
        if(idx == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //take
        temp.add(nums[idx]);
        subsetRec(nums,res, temp,idx+1);
        //skip
        temp.remove(temp.size()-1);
        subsetRec(nums,res, temp,idx+1);
    }

}
