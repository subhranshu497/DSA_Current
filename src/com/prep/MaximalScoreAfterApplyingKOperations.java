package com.prep;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    public static void main(String[] args) {
        int [] nums = {10,10,10,10,10};
        int k = 5;
        long maxE = maxKelements(nums, k);
        System.out.println(maxE);
    }

    private static long maxKelements(int[] nums, int k) {
        //to get the maximum result take the max element in the array and do the ops
        // so optimal data structure is to solve this problem is max heap
        // in java default is min heap , so sort it
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        long result = 0;
        int n = nums.length;
        for(int num :nums){
            pq.add(num);
        }
        while(k !=0){
            int curr = pq.poll();
            result +=curr;
            curr = Math.ceilDiv(curr, 3);
            pq.add(curr);
            k--;
        }
        return result;
    }
}
