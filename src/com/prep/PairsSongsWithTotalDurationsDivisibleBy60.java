package com.prep;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

public class PairsSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        int [] time = {20,40};
        int numsPair = numPairsDivisibleBy60(time);
        System.out.println(numsPair);
    }

    private static int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int rem = time[i] % 60;
            int target = 60 - rem;
            if(map.containsKey(target)) ans +=map.get(target);
            if(rem !=0) map.put(rem, map.getOrDefault(rem,0)+1);
            else map.put(60, map.getOrDefault(60,0)+1);
        }
        return ans;
    }
}
