package com.prep.Backtracking1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private static List<List<Integer>> results=new ArrayList<>();;
    public static void main(String[] args) {
        int [] candidates = {2,3,5};
        int target = 8;
        results = comSumOne(candidates, target);
        System.out.println(results);
    }

    private static List<List<Integer>> comSumOne(int[] candidates, int target) {
        comSumOneRecursion(candidates,target, new ArrayList<>(),0);
        return results;
    }

    private static void comSumOneRecursion(int[] candidates, int target, List<Integer> list, int i) {
        //base conidion
        if(i==candidates.length){
            if(target==0){
                results.add(new ArrayList<>(list));
            }
            return;
        }
        if(target>=candidates[i]){
            list.add(candidates[i]);
            comSumOneRecursion(candidates,target-candidates[i],list,i);
            list.remove(list.size()-1);
        }
        comSumOneRecursion(candidates,target,list,i+1);
    }
}
