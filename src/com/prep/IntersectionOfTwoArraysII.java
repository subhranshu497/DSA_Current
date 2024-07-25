package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        int [] result = intersectArr(nums1, nums2);
    }

    private static int[] intersectArr(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for(int i=0;i< nums2.length;i++){
            if(map.containsKey(nums2[i])){
                result.add(nums2[i]);
                map.put(nums2[i], map.getOrDefault(nums2[i], 0)-1);
            }
            if(map.containsKey(nums2[i])){
                int val = map.get(nums2[i]);
                if(val==0) map.remove(nums2[i]);
            }
        }
        int[] resArr = new int[result.size()];
        for(int i=0;i<result.size();i++){
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
