package com.prep.hackerRank.RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private static List<List<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        resultList = comSum(candidates,target);
    }

    private static List<List<Integer>> comSum(int[] candidates, int target) {
        comSumRec(0,candidates, target, new ArrayList<>());
        return resultList;
    }

    private static void comSumRec(int index, int[] candidates, int target, List<Integer> list) {
        //base condition
        if(index==candidates.length){
            if(target==0){
                resultList.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[index]<=target){
            list.add(candidates[index]);
            comSumRec(index,candidates,target-candidates[index],list);
            list.remove(list.size()-1);
        }
        comSumRec(index+1,candidates,target,list);
    }
}
