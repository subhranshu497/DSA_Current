package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));
    }

    private static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        //find maxfreq
        int maxFreq = 0;
        for(int key:freqMap.keySet()){
            int val = freqMap.get(key);
            maxFreq = Math.max(val, maxFreq);
        }
        int freqOfMaxFreq = 0;
        for(int val:freqMap.values()){
            if (val==maxFreq)freqOfMaxFreq++;
        }
        return maxFreq*freqOfMaxFreq;
    }
}
