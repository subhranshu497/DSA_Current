package com.prep;

import java.util.Arrays;
import java.util.Comparator;

public interface MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }

    static int minMeetingRooms(int[][] intervals) {
        int meetingRoomsCount =1;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1])meetingRoomsCount++;
        }
        return meetingRoomsCount;
    }
}
