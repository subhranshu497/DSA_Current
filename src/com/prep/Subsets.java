package com.prep;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> resultSet = new ArrayList<>();
    public static void main(String[] args) {
        int [] nums = {1,2,3};
       findSubsets(nums);
    }
    private static List<List<Integer>> findSubsets(int [] nums){
        backTrackSubsets(nums, new ArrayList<Integer>(),0);
        return resultSet;
    }

    private static void backTrackSubsets(int[] nums, ArrayList<Integer> temp, int index) {
        resultSet.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            backTrackSubsets(nums, temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
