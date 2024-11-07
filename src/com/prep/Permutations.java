package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    private static List<List<Integer>> result = new ArrayList<>();
    private static int n;
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        result = permutation(nums);
        for(List<Integer> l:result)
            System.out.println(l);
    }

    private static List<List<Integer>> permutation(int[] nums) {
        n = nums.length;
        solvePer(nums,new ArrayList<>(), new HashSet<>());
        return result;
    }

    private static void solvePer(int[] nums, List<Integer> temp, Set<Integer> set) {
        //base condition
        if(temp.size()==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            //add
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                temp.add(nums[i]);
                //explore
                solvePer(nums, temp, set);
                //remove
                set.remove(nums[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
