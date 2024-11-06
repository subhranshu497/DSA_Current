package com.prep.leetcode150.inerval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static void main(String[] args) {
        int [] nums = {0,1,2,4,5,7};
        List<String> result = summaryRanges(nums);
        System.out.println(result);
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        for (int i=0;i<n;i++){
            int start =nums[i];
            String s="";
            while (i+1 <n && nums[i]+1 ==nums[i+1])i++;
            if(start !=nums[i]){
              s   = start+""+"->"+nums[i];
            }
            else s = String.valueOf(start);
            result.add(s);
        }
        return result;
    }
}
