package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findAllDups(nums);
        System.out.println(result);
    }

    private static List<Integer> findAllDups(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> hs = new HashSet<>();
        for(int num:nums){
            if(!hs.contains(num)) hs.add(num);
            else result.add(num);
        }
        return result;
    }
    private static List<Integer> findAllDupsConstantSpace(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int indexToCheck = Math.abs(nums[i])-1;
            if(nums[indexToCheck]<0) result.add(indexToCheck+1);
            nums[indexToCheck] = nums[indexToCheck]*-1;
        }
        return result;
    }
}
