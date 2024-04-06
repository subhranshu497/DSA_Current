package com.prep;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] num1 = {1,2,2,1};
        int [] num2 = {2,2};
        int [] result =intersectionArr(num1,num2);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] intersectionArr(int[] num1, int[] num2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        for(int num:num1){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        for(int num:num2){
            if(freqMap.containsKey(num))result.add(num);
        }
        int[] output = new int[result.size()];
        int i=0;
        for(int num:result){
            output[i++] = num;
        }
        return output;
    }
}
