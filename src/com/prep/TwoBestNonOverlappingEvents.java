package com.prep;

import javax.swing.*;
import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    static int n;
    public static void main(String[] args) {
        int [][] events = {{1,3,2},{4,5,2},{2,4,3}};
        int inverval = maxTwoEvents(events);
        System.out.println(inverval);
    }

    private static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        n = events.length;
        int [][] memo = new int[n+1][3];
        for(int [] arr :memo)
            Arrays.fill(arr, -1);
        int result = maxTwoEventRecursion(events,0,0,memo);
        return result;
    }

    private static int maxTwoEventRecursion(int[][] events, int i,int count, int [][] memo) {
        //base condition
        if(count==2 || i>=n) return 0;
        if(memo[i][count] != -1)return memo[i][count];
        //take
        int nextValidIdx = binarySearchFindValidIdx(events,events[i][1]);
        int take = events[i][2]+maxTwoEventRecursion(events, nextValidIdx, count+1, memo);
        //skip
        int skip = maxTwoEventRecursion(events,i+1,count, memo);

        return memo[i][count] = Math.max(take, skip);
    }

    private static int binarySearchFindValidIdx(int[][] events, int end) {
        int l = 0;
        int r = n-1;
        int res = n;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(events[mid][0]>end){
                res = mid;
                r = mid-1;
            }
            else
                l= mid+1;
        }
        return res;
    }
}
