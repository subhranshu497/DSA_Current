package com.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumTotalImportanceOfRoads {
    public static void main(String[] args) {
        int [][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int n =5;
        long result = maximumImportance(roads, n);
    }

    private static long maximumImportance(int[][] roads, int n) {
       long [] indgrees = new long[n];
       for(int[] edge:roads){
           indgrees[edge[0]]++;
           indgrees[edge[1]]++;
       }
        Arrays.sort(indgrees);
       for(long i:indgrees){
           System.out.print(i+" ");
       }

       long value =1;
       long imp =0;
    for(int i=0;i<n;i++){
        imp +=indgrees[i]*value;
        value++;
    }
        System.out.println(imp);
        return imp;
    }
}
