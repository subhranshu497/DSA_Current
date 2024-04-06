package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int [] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNum(nums));
    }

    private static int missingNum(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums) numSet.add(num);
        int count = nums.length+1;
        for(int i=0;i<count;i++){
            if(!numSet.contains(i)) return i;
        }
        return -1;
    }
}
