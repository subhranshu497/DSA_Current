package com.prep;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSquareStreakInAnArray {
    public static void main(String[] args) {
        int [] nums ={4,3,6,16,8,2};
        int len = longestSquareStreak(nums);
        System.out.println(len);
    }

//    private static int longestSquareStreakSet(int [] nums){
//        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//        int maxStreak =0;
//        for(int num:nums){
//
//            if(num > 100000) break;
//            while (set.contains(num)){
//
//            }
//        }
//    }

    private static int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int ans = 0;
        for(int num:nums){
            int root = (int)Math.sqrt(num);
            if(root * root == num && map.containsKey(root)){
                map.put(num, map.get(root)+1);
            }
            else map.put(num, 1);
            ans = Math.max(ans, map.get(num));
        }
        return ans > 2 ? ans :-1;
    }


    private static int longestSquareStreakRecursion(int[] nums) {
        Arrays.sort(nums);
        int len = solvelongestSqStreakArray(nums, 0, new ArrayList<>(), 0);
        return len;
    }

    private static int solvelongestSqStreakArray(int[] nums, int i, List<Integer> ds, int currLen) {
        //base condition
        if(i < nums.length && ds.size() > currLen){
            currLen = ds.size();
            return currLen;
        }
        int take = 0;
        if(i==0){
            ds.add(nums[i]);
            take += solvelongestSqStreakArray(nums,i+1,ds,ds.size());
        }
        else if(nums[i]==Math.pow(ds.get(ds.size()-1),2)){
            ds.add(nums[i]);
            take += solvelongestSqStreakArray(nums,i+1,ds,ds.size());
        }
        int skip = solvelongestSqStreakArray(nums,i+1,ds,ds.size());
        return Math.max(take, skip);
    }
}
