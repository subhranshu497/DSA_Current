package com.prep;

import java.util.*;

public class RelativeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int [] result = relSortArr(arr1, arr2);
    }

    private static int[] relSortArr(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> remain = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<len2;i++){
            map.put(arr2[i],0);
        }
        for(int i=0;i<len1;i++){
            if(map.containsKey(arr1[i])){
                int val = map.get(arr2[i]);
                map.put(arr2[i],val+1);
            }else{
                remain.add(arr1[i]);
            }
        }
        Collections.sort(remain);
        for(int i=0;i<len2;i++){
            for(int j=0;j<map.get(arr2[i]);j++){
                result.add(arr2[i]);
            }
        }
        result.addAll(remain);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
