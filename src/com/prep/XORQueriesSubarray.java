package com.prep;

import java.util.ArrayList;
import java.util.List;

public class XORQueriesSubarray {
    public static void main(String[] args) {
        int [] arr = {16};
        int [][] queries = {{0,0},{0,0},{0,0}};
        int [] result =xorQueries(arr, queries);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int [] cumXorArr = new int[n];
        cumXorArr[0] = arr[0];
        for(int i=1;i<n;i++){
            cumXorArr[i] = cumXorArr[i-1]^arr[i];
        }
        int[] result = new int[queries.length];
        List<Integer> list = new ArrayList<>();
        int i=0;
        for(int [] q:queries){
            int l= q[0];
            int r= q[1];
            int value = cumXorArr[r] ^ (l==0?0:cumXorArr[l-1]);
            result[i]=value;
            i++;
        }
        return result;
    }
}
