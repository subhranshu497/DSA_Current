package com.prep;

import java.util.*;

public class LongestCommonSubsequenceBetweenSortedArrays {
    public static void main(String[] args) {
        int[][] arrays = {{1,3,4},{1,4,7,9}};
        List<Integer> result = longestCommonSubsequence(arrays);
        System.out.println(result);
    }

    private static List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        int m = arrays.length;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<arrays[i].length;j++){
                map.put(arrays[i][j], map.getOrDefault(arrays[i][j],0)+1);
                if(map.get(arrays[i][j])==m)result.add(arrays[i][j]);
            }
        }
        return result;
    }
}
