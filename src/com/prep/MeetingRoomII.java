package com.prep;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public static void main(String[] args) {
        int[][]intervals ={{7,10},{2,4}};
        System.out.println(meetingRoomRequired(intervals));
    }

    private static int meetingRoomRequired(int[][] intervals) {
        //sort the array based on first index
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int [] interval : intervals){
            if(pq.size()==0){
                pq.add(interval[1]);
            }
            else{
                if(pq.peek()>interval[0]){
                    pq.add(interval[1]);
                }
                else{
                    pq.remove();
                    pq.add(interval[1]);
                }
            }
        }
        return pq.size();

    }
}
