package com.prep;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CheckIfArrayPairsAreDivisibleByk {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int k = 10;
        boolean flag = canArrange(arr,k);
        System.out.println(flag);
    }

    private static boolean canArrange(int[] arr, int k) {
        // key = num%k , val = the num whose mod is same
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int mod = arr[i]%k;
            if(mod<0) mod +=k;
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(key==0 && val % 2 == 0) continue;
            if(!map.containsKey(k-key)) return false;
            else{
                int val2 = map.get(k-key);
                if( val2 !=val) return false;
            }
        }
        return true;
    }
}
