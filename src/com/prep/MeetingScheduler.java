package com.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MeetingScheduler {
    public static void main(String[] args) {
        int [][] slot1 = {{10,50},{60,120},{140,210}};
        int [][] slot2 = {{0,15},{60,70}};
        int duration = 8;
        List<Integer> minDuration = minAvailableDuration(slot1, slot2, duration);
        System.out.println(minDuration);
    }

    private static List<Integer> minAvailableDuration(int[][] slot1, int[][] slot2, int duration) {
        int slot1Ptr = 0;
        int slot2Ptr =0;
        int slot1Len = slot1.length;
        int slot2Len = slot2.length;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(slot1, (a,b)->a[0]-b[0]);
        Arrays.sort(slot2, (a,b)->a[0]-b[0]);
        while(slot1Ptr <slot1Len && slot2Ptr < slot2Len){
            start = Math.max(slot1[slot1Ptr][0], slot2[slot2Ptr][0]);
            end = Math.max(slot1[slot1Ptr][1], slot2[slot2Ptr][1]);
            if(end-start >=duration) {
                result.add(start);
                result.add(start+duration);
                return result;
            }
            else if(slot1[slot1Ptr][1]<slot2[slot2Ptr][1])slot1Ptr++;
            else slot2Ptr++;
        }
        return result;
    }
}
