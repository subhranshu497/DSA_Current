package com.prep;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findLargest(nums,k));
    }

    private static int findLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //build a pq of k size
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]> pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
