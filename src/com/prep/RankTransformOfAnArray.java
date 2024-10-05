package com.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    public static void main(String[] args) {
        int [] arr = {40,10,20,30};
        int [] res = arrayRankTransform(arr);
    }

    private static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int [] copyArr = Arrays.copyOf(arr, n);
        Arrays.sort(copyArr);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(copyArr[0], 1);
        for(int i=1;i<n;i++){
            if(copyArr[i] > copyArr[i-1]){
                map.put(copyArr[i], map.get(copyArr[i-1])+1);
            }
            else map.put(copyArr[i], map.get(copyArr[i-1]));
        }
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]= map.get(arr[i]);
        }
        return res;
    }
}
