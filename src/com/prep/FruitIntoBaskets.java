package com.prep;

import java.util.*;

/**
 * Leetcode 904
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int left =0;
        int right =0;
        int result =0;
        for(;right<fruits.length;right++){
            baskets.put(fruits[right],baskets.getOrDefault(fruits[right],0)+1);
            while(baskets.size()>2){
                baskets.put(fruits[left],baskets.get(fruits[left])-1);
                if (baskets.get(fruits[left]) == 0)baskets.remove(fruits[left]);
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
