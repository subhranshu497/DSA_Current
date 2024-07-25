package com.prep;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanking {
    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        String[] result = findRelativeRanks(score);
        for(String s:result) System.out.print(s+", ");
    }

    private static String[] findRelativeRanks(int[] score) {
        int[] scoreCopy = new int[score.length];
        Map<Integer, Integer> map = new HashMap<>();
        String[] strArr = new String[score.length];
        int n = score.length;
        System.arraycopy(score,0,scoreCopy,0,n);
        int marker =1;
        for(int i=0;i<n;i++){
            map.put(scoreCopy[i],i);
        }
        Arrays.sort(scoreCopy);
        System.out.println(map);
        for(int i=0;i< score.length;i++){
            if(i==0){
                strArr[map.get(scoreCopy[n-i-1])] ="Gold Medal";
            }
            else if(i==1){
                strArr[map.get(scoreCopy[n-i-1])] ="Silver Medal";
            }
            else if(i==2){
                strArr[map.get(scoreCopy[n-i-1])] ="Bronze Medal";
            }
            else {
                strArr[map.get(scoreCopy[n-i-1])] =Integer.toString(i+1);
            }
        }
        return strArr;
    }
}
