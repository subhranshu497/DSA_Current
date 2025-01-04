package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisibleSumPairs {

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(3);
        ar.add(2);
        ar.add(6);
        ar.add(1);
        ar.add(2);
        int ans = divisibleSumPairs(6,3,ar);
        System.out.println(ans);
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0;i<n;i++){
            int rem1 = ar.get(i) % k;
            if(rem1 < 0)
                rem1 +=k;
            int rem = (k-rem1) % k;
            if(map.containsKey(rem)){
                result +=map.get(rem);
            }
            map.put(rem1, map.getOrDefault(rem1, 0)+1);
        }
        System.out.println(map);
        return result;

    }
}
