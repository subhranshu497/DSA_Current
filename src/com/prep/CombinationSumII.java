package com.prep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int [] candidates = {2,1,5,6,1,7,10};
        int target = 8;
        Arrays.sort(candidates);
        ans = combinationSumII(candidates, target);
        for(List<Integer> l:ans) System.out.println(l);
    }

    private static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        comSumIIHelper(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private static void comSumIIHelper(int[] candidates, int target, int idx, ArrayList<Integer> ds) {
        //base condition
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        //exit
        if(target<0) return;
        for(int i=idx;i<candidates.length;i++){
            //duplicate
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            ds.add(candidates[i]);
            comSumIIHelper(candidates, target-candidates[i], i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
}
