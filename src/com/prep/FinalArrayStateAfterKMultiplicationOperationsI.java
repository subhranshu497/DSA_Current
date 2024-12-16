package com.prep;

import java.beans.PropertyEditorSupport;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static void main(String[] args) {
        int [] nums = {2,1,3,5,6};
        int k =5;
        int multiplier = 2;
        int [] rsult = getFinalState(nums, k, multiplier);
        for(int num: rsult)
            System.out.print(num+", ");
    }

    //(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    private static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0;i< nums.length;i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(k !=0){
            int[] curr = pq.poll();
            int val = curr[0];
            int idx = curr[1];
            nums[idx] = val*multiplier;
            pq.offer(new int []{nums[idx],idx});
            k--;
        }
        return nums;
    }
}
