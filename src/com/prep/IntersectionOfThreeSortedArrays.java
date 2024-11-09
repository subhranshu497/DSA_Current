package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfThreeSortedArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5}, arr2 = {1,2,5,7,9}, arr3 = {1,3,4,5,8};
        List<Integer> result = arraysIntersection(arr1, arr2, arr3);
        System.out.println(result);
    }

    private static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num:arr1)
            map.put(num, map.getOrDefault(num,0)+1);
        for(int num:arr2)
            map.put(num, map.getOrDefault(num,0)+1);
        for(int num:arr3)
            map.put(num, map.getOrDefault(num,0)+1);
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(val==3)
                result.add(key);
        }
        return result;
    }
}
