package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] num1 ={1,2,3};
        int[] num2 = {2,4,6};
        List<List<Integer>> result = findDifference(num1, num2);
        System.out.println(result);
    }

    private static List<List<Integer>> findDifference(int[] num1, int[] num2) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int num:num1) map1.put(num, map1.getOrDefault(num, 0)+1);
        for(int num:num2) map2.put(num, map2.getOrDefault(num, 0)+1);
        for(int key:map1.keySet()){
            if(!map2.containsKey(key)){
                list1.add(key);
            }
        }
        for(int key:map2.keySet()){
            if(!map1.containsKey(key)){
                list2.add(key);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}
