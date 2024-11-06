package com.prep.leetcode150.inerval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] results = mergeOne(intervals);
        for(int [] arr:results){
            System.out.print(arr[0]+", "+arr[1]);
            System.out.println();
        }
    }

    private static int[][] mergeOne(int[][] intervals) {
        if(intervals.length ==1)return intervals;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int [] firstInterval = intervals[0];
        for(int i=0;i<intervals.length;i++){
            int [] newInterval = new int[2];
            //case for the merge
            if(intervals[i][0] <= intervals[i-1][1]){
                newInterval[0] = intervals[i-1][0];
                newInterval[1] = intervals[i][1];
                result.add(newInterval);
            }
            else{
                newInterval[0] = intervals[i][0];
                newInterval[1] = intervals[i][1];
                result.add(newInterval);
            }
        }
        //convert to array
        int [][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            int [] arr = result.get(i);
            res[i] = arr;
        }
        return res;
    }
}
