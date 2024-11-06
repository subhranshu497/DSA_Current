package com.prep;

import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static void main(String[] args) {
        int [][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        int group = minGroups(intervals);
        System.out.println(group);
    }

    private static int minGroups(int[][] intervals) {
        int n = intervals.length;
        // from this two d array , create two separate arrays
        //sort them
        //keep on iterating
        //visdualize this prob with the train and platform problem
        int [] start = new int[n];
        int [] end = new int[n];
        int k=0;
        for(int[] arr:intervals){
            start[k]=arr[0];
            end[k]=arr[1];
            k++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count =1;
        int ans =1;
        int i=1;
        int j=0;
        while(i<n && j<n){
            if(start[i] <= end[j]){
                count++;
                i++;
            }
            else {
                j++;
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
