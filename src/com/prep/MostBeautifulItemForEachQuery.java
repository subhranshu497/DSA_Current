package com.prep;

import java.util.Arrays;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        int [][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int [] queries = {1,2,3,4,5,6};
        int [] result = maximumBeauty(items, queries);
        for(int num:result) System.out.print(num+", ");
    }

    private static int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int [] result = new int[queries.length];
        Arrays.sort(items, (a,b)->a[0]-b[0]);
        int maxBeauty = items[0][1];
        // iterate the item array and assign the max beauty till the price
        for(int i=1;i<n;i++){
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }
        for(int i=0;i< queries.length;i++){
            int qp = queries[i];
            result[i] = binarySearch1(qp, items);
        }
        return result;
    }

    private static int binarySearch1(int qp, int[][] items) {
        int left =0;
        int right = items.length-1;
        int maxBeauty = 0;
        int mid = 0;
        while (left <= right){
             mid = left+(right-left)/2;
            if(items[mid][0]>qp)
                right = mid-1;
            else{
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                left= mid+1;
            }
        }
        return maxBeauty;
    }
}
