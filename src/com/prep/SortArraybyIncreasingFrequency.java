package com.prep;

import java.util.*;

public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        int [] nums = {1,1,2,2,2,3};
        int [] results = frequencySortDaily(nums);
    }

    public static int[] frequencySortDaily(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list, (a,b)->{
            if(freq.get(a)==freq.get(b)){
                return b-a;
            }
            else return freq.get(a)-freq.get(b);
        });
        int idx =0;
        for(int item:list){
            for(int i=0;i<freq.get(item);i++){
                result[idx++]= item;
            }
        }
        return result;
    }
}
