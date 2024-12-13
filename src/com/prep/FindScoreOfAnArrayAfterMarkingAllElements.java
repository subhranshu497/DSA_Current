package com.prep;

import java.util.Arrays;

public class FindScoreOfAnArrayAfterMarkingAllElements {
    public static void main(String[] args) {
        int [] nums = {2,1,3,4,5,2};
        long score = findScore(nums);
        System.out.println(score);
    }

    private static long findScore(int[] nums) {
        int [][] pairs = new int[nums.length][2];
        for(int i=0;i< nums.length;i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        //sort
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        boolean[] marked = new boolean[nums.length];
        long score = 0;
        for(int [] pair:pairs){
            int value = pair[0];
            int index = pair[1];
            if(!marked[index]){
                score +=value;
                marked[index] = true;
                if(index >0)
                    marked[index - 1] = true;
                if(index < nums.length-1)
                    marked[index + 1] =true;
            }
        }
        return score;
    }
}
