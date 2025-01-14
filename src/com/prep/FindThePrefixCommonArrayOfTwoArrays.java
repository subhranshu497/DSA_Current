package com.prep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindThePrefixCommonArrayOfTwoArrays {
    public static void main(String[] args) {
        int [] A = {1,3,2,4}, B = {3,1,2,4};
        int [] C = findThePrefixCommonArray(A, B);
        for(int c:C)
            System.out.print(c+", ");
    }

    private static int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int [] C = new int[A.length];
        int count =0;

        for(int i=0;i< A.length;i++){
            map.put(A[i], map.getOrDefault(A[i],0)+1);
            if(map.get(A[i])==2)
                count++;
            map.put(B[i], map.getOrDefault(B[i],0)+1);
            if(map.get(B[i])==2)
                count++;
            C[i] = count;
        }
        return C;
    }
}
