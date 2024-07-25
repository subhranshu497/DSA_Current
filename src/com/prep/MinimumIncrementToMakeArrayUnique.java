package com.prep;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] arr={3,2,1,2,1,7};
        int count = minIncForUnique(arr);
        System.out.println(count);
    }

    private static int minIncForUnique(int[] arr) {
        Arrays.sort(arr);
        int result =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>=arr[i]){
                int inc = arr[i-1]-arr[i]+1;
                result +=inc;
                arr[i]=arr[i-1]+1;
            }
        }
        return result;
    }
}
