package com.prep;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int [] arr = {4,3,2,1,0};
        int chunk = maxChunksToSorted(arr);
        System.out.println(chunk);
    }

    private static int maxChunksToSorted(int[] arr) {
        int chnk = 0;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, arr[i]);
            if(max==i)
                chnk++;
        }
        return chnk;
    }
}
