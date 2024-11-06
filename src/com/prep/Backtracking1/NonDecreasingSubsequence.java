package com.prep.Backtracking1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequence {
    public static void main(String[] args) {
        int [] nums = {4,6,7,7};
        List<List<Integer>> result = findSussequences(nums);
        for(List<Integer> list :result){
            System.out.println(list);
        }
    }

    private static List<List<Integer>> findSussequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrackingNDS(nums, n, 0, new ArrayList<>(),result);
        return result;
    }

    private static void backtrackingNDS(int[] nums, int n, int idx, List<Integer> curr, List<List<Integer>> result) {
        //since the subsequence should have at least 2 elements
        if(curr.size() >1){
            result.add(new ArrayList<>(curr));
        }
        Set<Integer> set= new HashSet<>();
        for(int i=idx;i<n;i++){
            if((curr.isEmpty() || nums[i]>=curr.get(curr.size()-1))&& !set.contains(nums[i])){
                curr.add(nums[i]);
                backtrackingNDS(nums, n, i+1,curr,result);
                curr.remove(curr.size()-1);
                set.add(nums[i]);
            }
        }
    }


}
