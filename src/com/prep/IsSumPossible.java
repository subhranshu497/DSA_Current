package com.prep;

import java.util.HashMap;
import java.util.Map;

public class IsSumPossible {
    public static void main(String[] args) {
        int amount = 4;
        int [] nums = {1,2,3};
        boolean flag = sumPos(amount,nums, new HashMap<>());
        System.out.println(flag);
    }

    private static boolean sumPos(int amount, int[] nums, Map<Integer, Boolean> memo) {
        //base case
        if(amount==0) return true;
        if(amount <0) return false;
        if(memo.containsKey(amount)) return memo.get(amount);
        for(int i=0;i< nums.length;i++){
            if(sumPos(amount-nums[i],nums, memo)) {
                memo.put(amount,true);
                return true;
            }
        }
        memo.put(amount,false);
        return false;
    }
}
