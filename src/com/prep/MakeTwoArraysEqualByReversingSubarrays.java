package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeTwoArraysEqualByReversingSubarrays {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        int [] target = {2,4,1,3};
        boolean flag = canBeEqual(arr, target);
        System.out.println(flag);
    }

    private static boolean canBeEqual(int[] arr, int[] target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int num:arr){
            map1.put(num, map1.getOrDefault(num,0)+1);
        }
        System.out.println(map1);
        for(int num:target){
            map2.put(num, map2.getOrDefault(num,0)+1);
        }
        System.out.println(map2);
        for(Map.Entry<Integer, Integer> e :map1.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(!map2.containsKey(key))return false;
            else if(map2.get(key) !=val) return false;
        }
        return true;
    }
}
