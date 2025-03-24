package com.prep;

import java.util.Arrays;

public class CountNoOfDaysWithoutMeetings {
    public static void main(String[] args) {
        int [][] meetings = {{5,7},{1,3},{9,10}};
        int days = 5;
        int res = countDays(days, meetings);
        System.out.println(res);
    }

    private static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int start =0;
        int end =0;
        int res=0;
        for(int [] meeting:meetings){
            int currStart = meeting[0];
            int currEnd = meeting[1];
            if(currStart > end){
                res +=currStart -end-1;
            }
            end = Math.max(currEnd, end);
        }
                    if(end < days){
                res +=days-end;
            }
        return res;
    }
}
