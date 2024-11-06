package com.prep;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class MaximumCoinsHeroesCanCollect {
    public static void main(String[] args) {
        int [] heros = {1,4,2};
        int [] monsters = {1,1,5,2,3};
        int [] coins = {2,3,4,5,6};
        long [] earnings = maximumCoinsOptimized(heros, monsters, coins);
        for(int i=0;i<heros.length;i++) System.out.print(earnings[i]+", ");
    }

    //correct solution - but gives tle
    private static long[] maximumCoins(int[] heros, int[] monsters, int[] coins) {
        int n =heros.length;
        int m = monsters.length;
        long[] earnings = new long[n];
        for(int i=0;i<n;i++){
            long earning =0;
            for(int j=0;j<m;j++){
                if(monsters[j]<=heros[i]){
                    earning +=coins[j];
                }
            }
            earnings[i] = earning;
        }
        return earnings;
    }
    //optimized
    //int [] heros = {1,4,2};
    private static long[] maximumCoinsOptimized(int[] heros, int[] monsters, int[] coins) {
        int n =heros.length;
        int m = monsters.length;
        long[] earnings = new long[n];
        TreeMap<Integer, Long> map = new TreeMap<>();
        map.put(0,0l);
        for(int i=0;i<m;i++){
            if(!map.containsKey(monsters[i]))
                map.put(monsters[i], (long)coins[i]);
            else {
                long val = map.get(monsters[i]);
                map.put(monsters[i], map.getOrDefault(monsters[i], val)+coins[i]);
            }
        }
        System.out.println(map);
        System.out.println("----------");
        long prefixSum =0;
        for(Map.Entry<Integer, Long> e:map.entrySet()){
            int key = e.getKey();
            prefixSum += e.getValue();
            map.put(key, prefixSum);
        }
        System.out.println(map);
        for(int i=0;i<n;i++){
            earnings[i] = map.floorEntry(heros[i]).getValue();
        }
        return earnings;
    }
}
