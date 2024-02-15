package com.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] merged = merge(intervals);

    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x->x[0]));
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for(int i=0;i<intervals.length;i++){
            if(newInterval[1] > intervals[i][0]){
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
            else{
                newInterval = intervals[i];
                ans.add(newInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
