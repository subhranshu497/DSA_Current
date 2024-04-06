package com.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr,k));
    }

    private static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:arr)freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        int []values= new int[freqMap.size()];
        int j=0;
        for(int num:freqMap.keySet()){
            int val = freqMap.get(num);
            values[j]=val;
            j++;
        }
        Arrays.sort(values);
        int n = values.length;
        for(int i=0;i<n;i++){
            if(k-values[i] > 0){
                k -=values[i];
            }
            else break;
            n--;
        }
        return n;
    }
}
