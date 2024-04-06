package com.prep.hackerRank.RecursionBackTracking;

import java.util.*;

/**
 * #40
 * each element can be counted only once
 */
public class CombinationSumTwo {
    private static Set<List<Integer>> resultSet = new HashSet<>();
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        resultSet = combinationSum2(candidates,target);
        for(List<Integer> item:resultSet) System.out.print(item+", ");
    }

    private static Set<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        comSumTwoRec(0,target,candidates,new ArrayList<>());
        return resultSet;
    }

    private static void comSumTwoRec(int index, int target, int[] candidates, List<Integer> list) {
        // base condition
        if(index==candidates.length){
            if(target==0){
                resultSet.add(list);
            }
            return;
        }
        if(target >=candidates[index]){
            list.add(candidates[index]);
            comSumTwoRec(index+1, target-candidates[index],candidates,list);
        }
    }
}
