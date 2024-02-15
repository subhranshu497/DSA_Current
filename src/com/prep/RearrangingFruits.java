package com.prep;

import java.util.*;

public class RearrangingFruits {
    public static void main(String[] args) {
        int [] basket1 = {4,2,2,2};
        int [] basket2 = {1,4,1,2};
        System.out.println(minCost(basket1,basket2));
    }

    private static int minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;
        int res=0;
        List<Integer> list = new ArrayList<>();
        for(int item:basket1) map.put(item, map.getOrDefault(item, 0)+1);
        for(int item:basket2) map.put(item, map.getOrDefault(item, 0)-1);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() %2 == 1) return -1;
            minValue = Math.min(minValue, e.getKey());
            for(int i=0;i<Math.abs(e.getValue())/2;i++)
                list.add(e.getKey());
        }
        Collections.sort(list);
        for(int i=0;i<list.size()/2;i++){
            res += Math.min(2*minValue ,list.get(i));
        }
        return res;
    }
}
